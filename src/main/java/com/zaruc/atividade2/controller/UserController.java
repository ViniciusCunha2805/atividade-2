package com.zaruc.atividade2.controller;

import java.util.List;
import com.zaruc.atividade2.model.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zaruc.atividade2.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<String> createUser(@RequestBody User user) {
    if (user.getName() == null || user.getLogin() == null || user.getPassword() == null) {
      return ResponseEntity.status(400).body("Todos os campos são obrigatórios.");
    }
    userService.adicionarUser(user);
    return ResponseEntity.status(201).body("Usuário criado com sucesso.");
  }

  @GetMapping
  public List<User> getUsers() {
    return userService.obterUsers();
  }

  @PutMapping("/{login}")
  public ResponseEntity<String> putMethodName(@PathVariable String login, @RequestBody User userNovo) {
    for (User user : userService.obterUsers()) {
      if (user.getLogin().equals(login)) {
        user.setName(userNovo.getName());
        user.setPassword(userNovo.getPassword());
        return ResponseEntity.status(200).body("Usuário atualizado com sucesso.");
      }
    }
    return ResponseEntity.status(404).body("Usuário não encontrado.");
  }

  @DeleteMapping("/{login}")
  public ResponseEntity<String> deleteUser(@PathVariable String login) {
    userService.obterUsers().removeIf(user -> user.getLogin().equals(login));
    return ResponseEntity.status(200).body("Usuário deletado com sucesso.");
  }

}