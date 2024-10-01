package com.personalsoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserManager userManager;

    @PostMapping
    public void createUser(@RequestParam String username, @RequestParam String password) {
        userManager.createUser(username, password);
    }

    @GetMapping
    public List<Map<String, Object>> getAllUsers() {
        return userManager.getAllUsers();
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        userManager.deleteUser(username);
    }

    @PutMapping("/{username}")
    public void updateUser(@PathVariable String username, @RequestParam String newPassword) {
        userManager.updateUser(username, newPassword);
    }

    // Deserialización insegura
    @PostMapping("/deserialize")
    public void deserializeObject(@RequestBody String serializedObject) {
        // Implementación de deserialización insegura
    }
}
