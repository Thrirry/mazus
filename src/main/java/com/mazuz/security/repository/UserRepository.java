package com.mazuz.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mazuz.model.security.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
