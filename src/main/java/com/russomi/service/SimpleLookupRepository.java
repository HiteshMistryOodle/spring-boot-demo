package com.russomi.service;


import com.russomi.domain.LookupObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleLookupRepository implements LookupRepository {

    @Override
    @Cacheable("defaultCache")
    public LookupObject getByName(String name) {
        simulateSlowService();  //FIXME: replace with actual database call
        return new LookupObject(name, "Default Description for Object");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 2000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}