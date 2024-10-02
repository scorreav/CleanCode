package com.personalsoft;

import static org.junit.jupiter.api.Assertions.*;

import com.personalsoft.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(Mockito)
class UserManagerTest {
    @Autowired
    private UserService userManager;

    @Test
    void testUserOperations() {
        // Múltiples aserciones y lógica condicional en un solo test
        userManager.createUser("testuser", "password123");
        var users = userManager.getAllUsers();
        assertTrue(users.size() > 0);

        if (users.size() > 0) {
            userManager.updateUser("testuser", "newpassword");
            users = userManager.getAllUsers();
            assertEquals("newpassword", users.get(0).get("password"));

            userManager.deleteUser("testuser");
            users = userManager.getAllUsers();
            assertTrue(users.stream().noneMatch(u -> u.get("username").equals("testuser")));
        }

        assertTrue(userManager.isValidPassword("ValidPass1!"));
        assertFalse(userManager.isValidPassword("invalidpass"));
    }
}