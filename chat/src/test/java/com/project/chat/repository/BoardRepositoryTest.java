package com.project.chat.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.chat.entity.Board;
import com.project.chat.entity.User;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @DisplayName("게시글 작성 테스트")
    public void saveAndRetrieveBoardFromUser() {

        Board board = User.builder()
                .email("test@example.com")
                .name("userA")
                .nickname("깡깡이")
                .build()
                .toBoardBuilder()
                .boardNumber(1)
                .title("test title")
                .build();

        boardRepository.save(board);

        // 해당 게시글을 작성한 사용자 조회
        Board board_id = boardRepository.findById(1).orElse(null);

        System.out.println(board_id.getWriter());

        Assertions.assertThat(board_id.getWriter().getNickname()).isEqualTo("깡깡이");

    }

}
