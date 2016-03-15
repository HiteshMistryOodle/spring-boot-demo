package com.russomi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);


        logger.debug(
                "\n\n" + "=========================================================\n"
                        + "ApplicationContext Bean Definitions: " + "\n"
                        + "=========================================================\n\n"
        );

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            logger.debug(beanName);
        }

        logger.debug(
                "\n\n" + "=========================================================\n"
        );
    }

    @PostConstruct
    public void logSomething() {
        logger.debug("Sample Debug Message");
        logger.trace("Sample Trace Message");
    }

}
