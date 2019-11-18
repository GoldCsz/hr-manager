package com.neuqsoft.demo.entity;

import io.swagger.annotations.ApiModel;
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

    private String name;

    private int sex;
}
