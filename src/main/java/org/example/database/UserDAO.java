package org.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {

    public void addUser(String name, String email, String password) {
        String sql = "INSERT INTO Users (name, email, password, isActive) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setBoolean(4, true);
            stmt.executeUpdate();

            System.out.println("Пользователь добавлен успешно.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
