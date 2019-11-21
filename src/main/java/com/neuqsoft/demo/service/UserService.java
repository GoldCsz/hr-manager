package com.neuqsoft.demo.service;

import com.neuqsoft.commons.spring.log.LogAnnotation;
import com.neuqsoft.commons.spring.message.GlobalMessage;
import com.neuqsoft.commons.util.UUIDUtils;
import com.neuqsoft.demo.constant.Constant;
import com.neuqsoft.demo.dto.PasswordDTO;
import com.neuqsoft.demo.dto.RegisterDTO;
import com.neuqsoft.demo.dto.UserInfoDTO;
import com.neuqsoft.demo.entity.UserEntity;
import com.neuqsoft.demo.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @LogAnnotation(value = "查看个人信息", params = true, result = true)
    public UserEntity getSelfInfo(String mobile) {
        UserEntity userEntity = userRepo.findByMobile(mobile);
        return userEntity;
    }

    @LogAnnotation(value = "修改个人信息", params = true, result = true)
    public GlobalMessage setSelfInfo(String mobile, UserInfoDTO userInfoDTO) {
        UserEntity userEntity = userRepo.findByMobile(mobile);
        BeanUtils.copyProperties(userInfoDTO, userEntity);
        userRepo.save(userEntity);
        return new GlobalMessage("0", "操作成功");
    }

    @LogAnnotation(value = "新用户注册", params = true, result = true)
    public GlobalMessage addRegister(RegisterDTO registerDTO) {
        UserEntity userEntity1 = userRepo.findByMobile(registerDTO.getMobile());
        if (userEntity1 != null) {
            throw Constant.ExceptionRepo.USER_EXIST;
        }
        UserEntity userEntity=new UserEntity();
        userEntity.setId(UUIDUtils.uuid32());
        BeanUtils.copyProperties(registerDTO, userEntity);
        userRepo.save(userEntity);
        return new GlobalMessage("0", "操作成功");
    }

    @LogAnnotation(value = "修改密码", params = true, result = true)
    public GlobalMessage setPassword(String mobile, PasswordDTO passwordDTO) {
        UserEntity userEntity = userRepo.findByMobile(mobile);
        if (!passwordDTO.getOldPassword().equals(userEntity.getPassword())) {
            throw Constant.ExceptionRepo.PASSWORD_NOT_EQUAL;
        }
        userEntity.setPassword(passwordDTO.getNewPassword());
        userRepo.save(userEntity);
        return new GlobalMessage("0", "操作成功");
    }



    


}
