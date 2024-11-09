package org.example;

import org.example.database.DatabaseConnector;
import org.example.models.tracker.ExpenseCategory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class TrackerApplication {
    public static void main(String[] args) {

//        try (Connection connection = DatabaseConnector.getConnection()) {
//            if (connection != null) {
//                System.out.println("Connected to the database.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Failed to connect to the database.");
//        }

        Locale locale = Locale.of("en");
//        Locale locale = Locale.of("pt", "PT");
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        for (ExpenseCategory category : ExpenseCategory.values()) {
            String categoryName = bundle.getString("ExpenseCategory." + category.name());
            System.out.println(categoryName);
        }

    }
}