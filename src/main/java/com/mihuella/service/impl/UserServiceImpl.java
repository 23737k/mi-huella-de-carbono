package com.mihuella.service.impl;

import com.mihuella.repositories.UserRepo;
import com.mihuella.security.User;
import com.mihuella.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private UserRepo userRepo;
  private PasswordEncoder passwordEncoder;

  public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
    this.userRepo = userRepo;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void addUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepo.save(user);
  }
}
