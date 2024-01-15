package com.project.chat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@NoArgsConstructor
@Entity(name = "user")
@Table(name = "user")
public class User {

    @Id
    private String email;
    private String name;
    private String nickname;
    private String type;
    private String role;

    @Builder
    public User(String email, String name, String nickname, String type, String role) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.type = type;
        this.role = role;
    }

    public Board.BoardBuilder toBoardBuilder() {
        return Board.builder().writer(this);
    }
}
