package com.neuqsoft.demo.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: chensz
 * @CreateTime: 2019-11-27 16:15
 * @Description:
 */
@Data
@Entity
@ApiModel(value = "RoleEntity",description = "角色表")
@Table(name = "ROLE")
public class RoleEntiity {

    @Id
    private String id;

    private String roleName;

    private String createTime;

    private String remark;
}
