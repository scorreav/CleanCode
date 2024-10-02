package com.personalsoft;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import com.personalsoft.dto.UserDto;
import com.personalsoft.model.User;
import com.personalsoft.repository.UserRepository;
import com.personalsoft.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;


class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    private UserDto userDto;
    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        userDto = new UserDto();
        userDto.setUsername("testuser");
        userDto.setPassword("password123");

        user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        user.setPassword("encodedPassword");
    }

    @Test
    void createUser_ShouldSaveUser() {
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        userService.createUser(userDto);

        verify(passwordEncoder).encode("password123");
        verify(userRepository).save(any(User.class));
    }

    @Test
    void getAllUsers_ShouldReturnListOfUserDtos() {
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));

        List<UserDto> result = userService.getAllUsers();

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("testuser", result.get(0).getUsername());
        assertNull(result.get(0).getPassword());
    }

    @Test
    void deleteUser_ShouldDeleteUserWhenFound() {
        when(userRepository.findByUsername("testuser")).thenReturn(user);

        userService.deleteUser("testuser");

        verify(userRepository).delete(user);
    }

    @Test
    void deleteUser_ShouldNotDeleteWhenUserNotFound() {
        when(userRepository.findByUsername("nonexistent")).thenReturn(null);

        userService.deleteUser("nonexistent");

        verify(userRepository, never()).delete(any(User.class));
    }

    @Test
    void updateUser_ShouldUpdatePasswordWhenUserFound() {
        when(userRepository.findByUsername("testuser")).thenReturn(user);
        when(passwordEncoder.encode("newPassword")).thenReturn("newEncodedPassword");

        userService.updateUser("testuser", "newPassword");

        verify(userRepository).save(user);
        assertEquals("newEncodedPassword", user.getPassword());
    }

    @Test
    void updateUser_ShouldNotUpdateWhenUserNotFound() {
        when(userRepository.findByUsername("nonexistent")).thenReturn(null);

        userService.updateUser("nonexistent", "newPassword");

        verify(userRepository, never()).save(any(User.class));
    }
}