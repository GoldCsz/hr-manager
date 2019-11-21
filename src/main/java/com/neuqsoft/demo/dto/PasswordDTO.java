package com.neuqsoft.demo.dto;

import lombok.Data;

/**
 * @Author: chensz
 * @CreateTime: 2019-11-19 10:52
 * @Description:
 */
@Data
public class PasswordDTO {

    private String OldPassword;

    private String NewPassword;
}
