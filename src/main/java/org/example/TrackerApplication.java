package org.example;

import org.example.models.tracker.ExpenseCategory;

import java.util.Locale;
import java.util.ResourceBundle;

public class TrackerApplication {
    public static void main(String[] args) {

//        Locale locale = Locale.of("en");
        Locale locale = Locale.of("pt", "PT");
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        for (ExpenseCategory category : ExpenseCategory.values()) {
            String categoryName = bundle.getString("ExpenseCategory." + category.name());
            System.out.println(categoryName);
        }

    }
}