package com.zaruc.atividade2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zaruc.atividade2.model.User;

@Service

public class UserService {
  private List<User> users = new ArrayList<>();

  public void adicionarUser(User user) {
    users.add(user);
  }

  public List<User> obterUsers() {
    return users;
  }

  public String buscarPorLogin(String login) {
    for (User user : users) {
      if (user.getLogin().equals(login)) {
        return "User found: " + user.getName();
      }
    }
    return "User not found.";
  }

}
