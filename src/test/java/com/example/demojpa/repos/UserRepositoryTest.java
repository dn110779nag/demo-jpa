package com.example.demojpa.repos;

import com.example.demojpa.repos.domain.BirthdayWrap;
import com.example.demojpa.repos.domain.Role;
import com.example.demojpa.repos.domain.User;
import com.example.demojpa.tcutil.BasicTestContainerTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest extends BasicTestContainerTest {

    @Autowired
    private UserRepository instance;


    @BeforeEach
    @AfterEach
    void clear(){
        instance.deleteAll();
    }

    @Test
    void saveAndFind() {
        User user = User.builder()
                .name("Тестовый Тест Тестович")
                .birthday(new BirthdayWrap(LocalDate.of(2000, 10, 12)))
                .role(Role.ADMIN)
                .build();

        User saved = instance.saveAndFlush(user);
        assertThat(saved).isNotNull()
                .extracting(User::getId).isNotNull();

        Optional<User> result = instance.findById(saved.getId());

        System.out.println("result ==> " + result);
        assertThat(result)
                .isPresent()
                .hasValueSatisfying( e -> {
                    assertThat(e.getRole()).isEqualTo(Role.ADMIN);
                    assertThat(e.getBirthday()).isEqualTo(new BirthdayWrap(LocalDate.of(2000, 10, 12)));
                    assertThat(e.getName()).isEqualTo("Тестовый Тест Тестович");
                    assertThat(e.getCreated()).isNotNull();
                    assertThat(e.getTlm()).isNotNull();
                });
        ;
    }
}