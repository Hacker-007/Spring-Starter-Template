package com.revan.SpringStarter.rest;

import com.revan.SpringStarter.dao.UserRepository;
import com.revan.SpringStarter.error.UserNotFoundException;
import com.revan.SpringStarter.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        repository.findAll().forEach(allUsers::add);
        return allUsers;
    }

    @GetMapping("/users/{id}")
    public User getOneUser(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping("/users")
    public User createOneUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @PutMapping("/users/{id}")
    public User updateOneUser(@RequestBody User newUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setRole(newUser.getRole());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    public void deleteOneUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
