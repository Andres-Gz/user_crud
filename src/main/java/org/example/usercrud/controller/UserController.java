package org.example.usercrud.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.example.usercrud.commons.dto.UserDTO;
import org.example.usercrud.commons.util.Views;
import org.example.usercrud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    @JsonView(Views.Create.class)
    public UserDTO create(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping("/update")
    @JsonView(Views.Update.class)
    public UserDTO update(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @GetMapping("/get/{id}")
    @JsonView(Views.Read.class)
    public UserDTO get(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    @JsonView(Views.Read.class)
    public List<UserDTO> getAll() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
