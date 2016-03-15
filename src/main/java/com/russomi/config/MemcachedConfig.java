package com.russomi.config;

import com.google.code.ssm.Cache;
import com.google.code.ssm.CacheFactory;
import com.google.code.ssm.aop.CacheBase;
import com.google.code.ssm.config.DefaultAddressProvider;
import com.google.code.ssm.providers.CacheConfiguration;
import com.google.code.ssm.providers.elasticache.ElastiCacheConfiguration;
import com.google.code.ssm.providers.elasticache.MemcacheClientFactoryImpl;
import com.google.code.ssm.spring.SSMCache;
import com.google.code.ssm.spring.SSMCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

@Profile({"elasticache", "memcached"})
@EnableCaching
@Configuration
public class MemcachedConfig extends CachingConfigurerSupport {
    private static final String CACHE_SERVERS = System.getenv("CACHE_SERVERS");

    @Autowired
    private Environment environment;

    @Bean
    public CacheBase cacheBase() {
        return new CacheBase();
    }


    @Bean
    public Cache defaultCache() {
        try {
            return cacheFactory().getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        Set<SSMCache> ssmCacheSet = new HashSet<>();
        SSMCache ssmCache = new SSMCache(defaultCache(), 300, false);

        ssmCacheSet.add(ssmCache);

        SSMCacheManager ssmCacheManager = new SSMCacheManager();
        ssmCacheManager.setCaches(ssmCacheSet);
        return ssmCacheManager;
    }

    @Bean
    @DependsOn("cacheBase")
    public CacheFactory cacheFactory() {
        CacheFactory cacheFactory = new CacheFactory();
        cacheFactory.setCacheName("defaultCache");
        cacheFactory.setCacheClientFactory(new MemcacheClientFactoryImpl());

        String cacheServers = CACHE_SERVERS;
        if (StringUtils.isEmpty(cacheServers)) {
            cacheServers = environment.getProperty("cache.servers");
        }

        CacheConfiguration cacheConfiguration = createCacheConfiguration();
        cacheFactory.setAddressProvider(new DefaultAddressProvider(cacheServers));
        cacheFactory.setConfiguration(cacheConfiguration);

        return cacheFactory;
    }


    private CacheConfiguration createCacheConfiguration() {
        ElastiCacheConfiguration cacheConfiguration = new ElastiCacheConfiguration();
        cacheConfiguration.setConsistentHashing(true);
        cacheConfiguration.setUseAutoDiscovery(true);
        return cacheConfiguration;
    }
}
