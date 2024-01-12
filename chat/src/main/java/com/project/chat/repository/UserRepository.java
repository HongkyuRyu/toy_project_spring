package com.project.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.chat.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
