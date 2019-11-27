package com.neuqsoft.demo.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: chensz
 * @CreateTime: 2019-11-26 13:51
 * @Description:
 */
@Data
@Entity
@ApiModel(value = "RoleMenuEntity",description = "角色菜单关联表")
@Table(name = "ROLE_MENU")
public class RoleMenuEntity {

    @Id
    private String id;

    private String RoleId;

    private String MenuId;
}
