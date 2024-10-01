package com.personalsoft;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserManagerTest {
    @Autowired
    private UserManager userManager;

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