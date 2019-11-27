package com.neuqsoft.demo.repository;

import com.neuqsoft.demo.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,String> {

    UserEntity findByMobile(String mobile);

    UserEntity findAllById(String id);

    Page<UserEntity> findAll(Specification<UserEntity> spec, Pageable pageable);
}
