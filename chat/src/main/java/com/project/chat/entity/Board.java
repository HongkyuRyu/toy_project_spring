package com.project.chat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "board")
@Table(name = "board")
public class Board {

    @Id
    private int boardNumber;
    private String title;

    @ManyToOne
    @JoinColumn(name = "writer", referencedColumnName = "nickname")
    private User writer;

    @Builder
    public Board(int boardNumber, String title, User writer) {
        this.boardNumber = boardNumber;
        this.title = title;
        this.writer = writer;
    }

}
