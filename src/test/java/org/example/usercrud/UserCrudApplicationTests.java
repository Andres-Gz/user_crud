package org.example.usercrud;

import org.example.usercrud.commons.dto.UserDTO;
import org.example.usercrud.commons.mapper.UserMapper;
import org.example.usercrud.model.User;
import org.example.usercrud.repository.IUserRepository;
import org.example.usercrud.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserCrudApplicationTests {

    @Mock
    private IUserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("John Doe");

        User user = new User();
        user.setName("John Doe");

        when(userMapper.convertToEntity(userDTO)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);

        UserDTO savedUserDTO = userService.createUser(userDTO);

        assertNotNull(savedUserDTO);
        assertEquals("John Doe", savedUserDTO.getName());

        verify(userMapper, times(1)).convertToEntity(userDTO);
        verify(userRepository, times(1)).save(user);
        verify(userMapper, times(1)).convertToDTO(user);
    }

}
