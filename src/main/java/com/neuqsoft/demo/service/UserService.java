package com.neuqsoft.demo.service;

import com.neuqsoft.commons.spring.log.LogAnnotation;
import com.neuqsoft.demo.entity.UserEntity;
import com.neuqsoft.demo.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: chensz
 * @CreateTime: 2019-11-18 13:39
 * @Description:
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @LogAnnotation(value = "查看所有的人员信息",params = true,result = true)
    public List<UserEntity> getUserInfo(){
        List<UserEntity> userEntityList=userRepo.findAll();
        return userEntityList;
    }
}
