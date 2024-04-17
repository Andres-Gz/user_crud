package org.example.usercrud.service;

import org.example.usercrud.commons.dto.UserDTO;

import java.util.List;

public interface IUserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    void deleteUser(Long id);

}
