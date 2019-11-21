package com.neuqsoft.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: chensz
 * @CreateTime: 2019-11-18 13:28
 * @Description:
 */
@Data
@Entity
@ApiModel(value = "UserEntity",description = "员工信息表")
@Table(name = "SYS_USER")
public class UserEntity {

    @Id
    private String id;

    @ApiModelProperty("员工号")
    private String userNum;

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

    private String password;

    @ApiModelProperty("角色")
    private String role;
}
