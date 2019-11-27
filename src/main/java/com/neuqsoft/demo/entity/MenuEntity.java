package com.neuqsoft.demo.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: chensz
 * @CreateTime: 2019-11-26 13:45
 * @Description:
 */
@Data
@Entity
@ApiModel(value = "MenuEntity",description = "菜单表")
@Table(name = "MENU")
public class MenuEntity {

    @Id
    private String id;

    private String menuName;

    private String parentId;

    private String remark;

    private String createTime;

}
