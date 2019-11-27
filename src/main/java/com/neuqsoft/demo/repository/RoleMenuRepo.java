package com.neuqsoft.demo.repository;

import com.neuqsoft.demo.entity.RoleMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMenuRepo extends JpaRepository<RoleMenuEntity,String> {

}
