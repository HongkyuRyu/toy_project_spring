package com.project.chat.dto;

//채팅 내용 Dto
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatDto {

    private enum MessageType {
        ENTER, LEAVE, TALK;
    }

    // 메시지 타입, 방 번호, 채팅보낸사람, 메시지, 채팅발송시간

    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
    private String time;
}
