package com.profesorp.capitalsservice.service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@CacheConfig(cacheNames = "users")
public class UserService {


    @Cacheable(cacheNames = "getuser")
    public String getUsers() throws InterruptedException {
        log.debug("Countries service");
        Thread.sleep(5000);
        return "capitals service";
    }

    @Cacheable(cacheNames = "someCache2")
    public String getNewCache() throws InterruptedException {
        Thread.sleep(5000);
        return "new cache";
    }
}
