package org.example;

import com.formdev.flatlaf.FlatLightLaf;
import org.example.views.MainView;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {

//        Locale locale = Locale.of("en");
//        Locale locale = Locale.of("pt", "PT");
//        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
//
//        for (ExpenseCategory category : ExpenseCategory.values()) {
//            String categoryName = bundle.getString("ExpenseCategory." + category.name());
//            System.out.println(categoryName);
//        }

        // Set FlatLaf look and feel
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class).headless(false).run(args);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainView(context);
            }
        });
    }
}