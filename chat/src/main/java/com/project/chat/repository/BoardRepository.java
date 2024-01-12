package com.project.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.chat.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
