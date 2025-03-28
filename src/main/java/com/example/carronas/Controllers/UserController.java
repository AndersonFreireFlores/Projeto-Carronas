package com.example.carronas.Controllers;

import com.example.carronas.Models.DTOs.UserDto;
import com.example.carronas.Models.User;
import com.example.carronas.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/users")
    public List<UserDto> getAll() {
        return service.getAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public UserDto getById(@RequestParam UUID id) {
        return service.getByID(id);
    }

    @PostMapping(path = "/users")
    public void postUser(@RequestBody User user) {
        service.createUser(user);
    }

    @PutMapping(path = "/users/{carronaId}")
    public User putUser(@RequestBody User user, @RequestParam UUID carronaID) {
        return service.updateUser(user, carronaID);
    }

    @PutMapping(path = "/user_carrona/{userId}/{carronaId}")
    public void putUserCarrona(@RequestParam UUID userId, @RequestParam UUID carronaID) {
        service.updateCarrona(userId, carronaID);
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@RequestParam UUID id){
        service.deleteUser(id);
    }


}
