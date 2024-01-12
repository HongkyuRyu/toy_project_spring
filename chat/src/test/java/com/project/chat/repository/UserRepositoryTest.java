package com.project.chat.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.chat.entity.User;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("유저 조회 테스트")
    public void saveAndRetrieveUser() {
        User user = User.builder()
                .email("test@example.com")
                .name("user1")
                .nickname("testnick")
                .build();
        userRepository.save(user);

        User findUserById = userRepository.findById("test@example.com").orElse(null);
        assertThat(findUserById).isNotNull();
        assertThat(findUserById.getName()).isEqualTo("user1");
        assertThat(findUserById.getNickname()).isEqualTo("testnick");

    }

}
