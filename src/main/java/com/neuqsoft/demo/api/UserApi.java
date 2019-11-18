package com.neuqsoft.demo.api;

import com.neuqsoft.demo.entity.UserEntity;
import com.neuqsoft.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: chensz
 * @CreateTime: 2019-11-18 13:44
 * @Description:
 */
@RestController
@RequestMapping("/api/user")
public class UserApi {

    @Autowired
    private UserService userService;

    @ApiOperation("查看人员信息")
    @GetMapping()
    public List<UserEntity> getUserInfo(){
        return userService.getUserInfo();
    }
}
