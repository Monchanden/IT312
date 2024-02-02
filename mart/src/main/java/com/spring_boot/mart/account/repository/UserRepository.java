package com.spring_boot.mart.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_boot.mart.account.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
   User findByUsernameAndPassword(String username, String password);
}
