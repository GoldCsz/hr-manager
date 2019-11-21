package com.neuqsoft.demo.api;

import com.neuqsoft.commons.spring.message.GlobalMessage;
import com.neuqsoft.demo.dto.PasswordDTO;
import com.neuqsoft.demo.dto.RegisterDTO;
import com.neuqsoft.demo.dto.UserInfoDTO;
import com.neuqsoft.demo.entity.UserEntity;
import com.neuqsoft.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public GlobalMessage Register(@RequestBody RegisterDTO registerDTO) {
        return userService.addRegister(registerDTO);
    }

    @ApiOperation("查看个人信息")
    @GetMapping("/{mobile}")
    public UserEntity getUserInfo(@PathVariable String mobile) {
        return userService.getSelfInfo(mobile);
    }

    @ApiOperation("修改个人信息")
    @PostMapping("/{mobile}")
    public GlobalMessage setUserInfo(@PathVariable String mobile, @RequestBody UserInfoDTO userInfoDTO) {
        return userService.setSelfInfo(mobile, userInfoDTO);
    }

    @ApiOperation("修改密码")
    @PostMapping("/{mobile}/pwd")
    public GlobalMessage setPassword(@PathVariable String mobile, @RequestBody PasswordDTO passwordDTO) {
        return userService.setPassword(mobile, passwordDTO);
    }
}
