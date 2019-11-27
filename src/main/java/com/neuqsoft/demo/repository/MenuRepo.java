package com.neuqsoft.demo.repository;

import com.neuqsoft.demo.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends JpaRepository<MenuEntity,String> {

}
