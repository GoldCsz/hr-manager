package com.neuqsoft.demo.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: chensz
 * @CreateTime: 2019-11-26 13:41
 * @Description:
 */
@Data
@Entity
@ApiModel(value = "DepartmentEntity",description = "部门表")
@Table(name="DEPARTMENT")
public class DepartmentEntity {

    @Id
    private String id;

    private String depNum;

    private String depName;

    private String location;

    private String remark;
}
