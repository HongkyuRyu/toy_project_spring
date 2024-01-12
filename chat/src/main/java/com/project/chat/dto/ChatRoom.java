package com.project.chat.dto;

import java.util.HashMap;
import java.util.UUID;

import lombok.Data;

@Data
public class ChatRoom {
    // 채팅방아이디, 채팅방이름, 채팅방인원수
    private String roomId;
    private String roomName;
    private long userCount;

    // 유저 UUID, 유저 아이디
    private HashMap<String, String> userList = new HashMap<String, String>();

    // 채팅방 create
    public ChatRoom create(String roomName) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.roomName = roomName;
        return chatRoom;
    }
}
