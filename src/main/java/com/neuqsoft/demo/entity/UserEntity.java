package com.neuqsoft.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
    @Excel(name = "员工号",width=15)
    private String userNum;

    @Excel(name = "姓名",width=15)
    private String name;

    @Excel(name = "性别",width=15)
    private int sex;

    @ApiModelProperty("身份证号")
    @Excel(name = "身份证号",width=15)
    private String idcard;

    @Excel(name = "手机号",width=15)
    private String mobile;

    @ApiModelProperty("部门")
    @Excel(name = "部门",width=15)
    private String dep;

    @ApiModelProperty("职位")
    @Excel(name = "职位",width=15)
    private String position;

    @ApiModelProperty("入司时间")
    @Excel(name = "入司时间",width=15)
    private String startTime;

    @Excel(name = "邮箱",width=15)
    private String mail;

    private String password;

    @ApiModelProperty("角色")
    private String roleId;
}
