package com.project.chat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "chatroom")
@Table(name = "chatroom")
public class ChatRoom {

    @Id
    private int roomId;
    private String roomName;

    @OneToOne
    @JoinColumn(name = "board_number")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "buyer")
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "seller")
    private User seller;

    @Builder
    public ChatRoom(int roomId, String roomName, Board board, User buyer, User seller) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.board = board;
        this.buyer = buyer;
        this.seller = seller;
    }
}
