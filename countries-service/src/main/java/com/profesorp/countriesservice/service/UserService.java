package com.profesorp.countriesservice.service;

import com.profesorp.countriesservice.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
      Thread.sleep(5000);
      return "countries service";
    }


    @Cacheable(cacheNames = "someCache")
    public String getNewCache() throws InterruptedException {
      Thread.sleep(5000);
      return "new cache";
    }


}
