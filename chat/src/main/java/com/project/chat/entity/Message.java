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
@Entity(name = "message")
@Table(name = "message")
public class Message {

    @Id
    private int messageId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private ChatRoom room;

    @ManyToOne
    @JoinColumn(name = "buyer")
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "seller")
    private User seller;

    private String content;

    @Builder
    public Message(int messageId, ChatRoom room, User buyer, User seller, String content) {
        this.messageId = messageId;
        this.room = room;
        this.buyer = buyer;
        this.seller = seller;
        this.content = content;
    }

}
