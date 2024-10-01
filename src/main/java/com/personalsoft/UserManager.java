package com.personalsoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

@Service
public class UserManager {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createUser(String username, String password) {
        // Inyección SQL
        String sql = "INSERT INTO users (username, password) VALUES ('" + username + "', '" + password + "')";
        jdbcTemplate.execute(sql);
    }

    public List<Map<String, Object>> getAllUsers() {
        return jdbcTemplate.queryForList("SELECT * FROM users");
    }

    public void deleteUser(String username) {
        // Más inyección SQL
        jdbcTemplate.execute("DELETE FROM users WHERE username = '" + username + "'");
    }

    public void updateUser(String username, String newPassword) {
        // Aún más inyección SQL
        jdbcTemplate.execute("UPDATE users SET password = '" + newPassword + "' WHERE username = '" + username + "'");
    }

    // Método con alta complejidad ciclomática
    public boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        } else if (!password.matches(".*[A-Z].*")) {
            return false;
        } else if (!password.matches(".*[a-z].*")) {
            return false;
        } else if (!password.matches(".*[0-9].*")) {
            return false;
        } else if (!password.matches(".*[!@#$%^&*()].*")) {
            return false;
        } else {
            return true;
        }
    }

    // Mal manejo de errores
    public void riskyOperation() {
        try {
            // Alguna operación riesgosa
            Connection conn = jdbcTemplate.getDataSource().getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute("DROP TABLE users");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
