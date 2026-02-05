package com.zaruc.atividade2.controller;

import com.zaruc.atividade2.model.User;
import com.zaruc.atividade2.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class AuthController {

  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/login")
  public String login(@RequestBody User loginRequest) {
    for (User user : userService.obterUsers()) {
      if (user.getLogin().equals(loginRequest.getLogin()) &&
          user.getPassword().equals(loginRequest.getPassword())) {
        return "Login sucedido";
      }
    }
    return "Login falhou: credenciais inválidas.";
  }

}
