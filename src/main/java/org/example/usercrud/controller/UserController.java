package org.example.usercrud.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.usercrud.model.User;
import org.example.usercrud.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserController {

    private final IUserService userService;

    UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("create/")
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }


}
