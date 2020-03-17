package com.profesorp.capitalsservice.controller;

import com.hazelcast.core.DistributedObject;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.profesorp.capitalsservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Qualifier("hazelcastInstance")
    @Autowired
    private HazelcastInstance instance;     // autowire hazel cast instance

    @RequestMapping("/write")
    public String getUser() throws InterruptedException {
        return userService.getUsers();

    }

    @GetMapping("/write-new")
    public String getNewCache() throws InterruptedException {
        return userService.getNewCache();
    }

    @GetMapping("/cache")
    public Collection<DistributedObject> getCache(){
        return instance.getDistributedObjects();
    }

    @GetMapping("/delete")
    public void deleteCache(){
        Collection<DistributedObject> distributedObjects = instance.getDistributedObjects();
        for (DistributedObject distributedObject : distributedObjects) {
            if (distributedObject instanceof IMap){
                final IMap<?, ?> map = (IMap) distributedObject;
                    map.clear();
            }
        }
    }
}