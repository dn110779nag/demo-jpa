package com.example.demojpa.repos;

import com.example.demojpa.repos.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
