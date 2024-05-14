package com.mihuella.repositories;

import com.mihuella.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
  User findByUsername(String username);
}
