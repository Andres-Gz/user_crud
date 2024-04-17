package org.example.usercrud.service;

import org.example.usercrud.commons.dto.UserDTO;
import org.example.usercrud.commons.mapper.UserMapper;
import org.example.usercrud.model.User;
import org.example.usercrud.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.convertToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User user = userMapper.convertToEntity(userDTO);
        if (user.getId() != null) {
            User updatedUser = userRepository.save(user);
            return userMapper.convertToDTO(updatedUser);
        }
        return null;
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return userMapper.convertToDTO(user);
        }
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> {
                    UserDTO userDTO = new UserDTO();
                    userDTO.setId(user.getId());
                    userDTO.setName(user.getName());
                    userDTO.setLastname(user.getLastname());
                    userDTO.setAge(user.getAge());
                    return userDTO;
                })
                .toList();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
