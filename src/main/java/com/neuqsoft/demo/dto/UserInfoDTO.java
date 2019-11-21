package com.neuqsoft.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: chensz
 * @CreateTime: 2019-11-19 10:07
 * @Description:
 */
@Data
public class UserInfoDTO {

    @ApiModelProperty("员工号")
    private String number;

    private String name;

    private int sex;

    @ApiModelProperty("身份证号")
    private String idcard;

    private String mobile;

    @ApiModelProperty("部门")
    private String dep;

    @ApiModelProperty("职位")
    private String position;

    @ApiModelProperty("入司时间")
    private String startTime;

    private String mail;

}
