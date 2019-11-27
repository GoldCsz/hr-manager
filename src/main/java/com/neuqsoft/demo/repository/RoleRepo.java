package com.neuqsoft.demo.repository;

import com.neuqsoft.demo.entity.RoleEntiity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntiity,String> {

}
