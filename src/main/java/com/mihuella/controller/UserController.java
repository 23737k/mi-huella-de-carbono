package com.mihuella.controller;

import com.mihuella.security.User;
import com.mihuella.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("login")
  public String loginPage(){
    return "login";
  }

  @RequestMapping("signup_form")
  public String registrationPage(Model model){
    model.addAttribute("user", new User());
    return "signup_form";
  }

  @PostMapping("process_registration")
  public String createUser(User user){
    userService.addUser(user);
    return "login";
  }
}
