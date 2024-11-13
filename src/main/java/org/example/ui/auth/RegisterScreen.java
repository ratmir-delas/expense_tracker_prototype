package org.example.ui.auth;

import org.example.models.user.User;
import org.example.service.user.UserService;
import org.example.util.UserSession;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterScreen extends JPanel {

    private Runnable onRegisterSuccess;
    private UserService userService;

    public RegisterScreen(ApplicationContext context, Runnable onRegisterSuccess, Runnable showLoginScreen) {
        userService = context.getBean(UserService.class);
        this.onRegisterSuccess = onRegisterSuccess;
        initRegister(showLoginScreen);
    }

    private void initRegister(Runnable showLoginScreen) {
        setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel("Register", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JLabel confirmPassLabel = new JLabel("Confirm Password:");
        JPasswordField confirmPassField = new JPasswordField();
        JButton registerButton = new JButton("Register");

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(passLabel);
        formPanel.add(passField);
        formPanel.add(confirmPassLabel);
        formPanel.add(confirmPassField);
        formPanel.add(new JPanel());
        formPanel.add(registerButton);

        add(formPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        JButton backToLoginButton = new JButton("Back to Login");
        bottomPanel.add(backToLoginButton);
        add(bottomPanel, BorderLayout.SOUTH);

        backToLoginButton.addActionListener(e -> showLoginScreen.run());

        registerButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passField.getPassword());
            String confirmPassword = new String(confirmPassField.getPassword());

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (password.length() < 2) {
                JOptionPane.showMessageDialog(null, "Password must be at least 8 characters", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
//            } else if (!email.contains("@")) {
//                JOptionPane.showMessageDialog(null, "Invalid email address", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (userService.getUserByEmail(email).isPresent()) {
                JOptionPane.showMessageDialog(null, "Email already in use", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                User newUser = userService.register(name, email, password);
                if (newUser == null) {
                    JOptionPane.showMessageDialog(null, "Registration failed", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                UserSession.getInstance().setUser(newUser);
                onRegisterSuccess.run(); // Navigate to main screen on successful registration

                // clear fields
                nameField.setText("");
                emailField.setText("");
                passField.setText("");
                confirmPassField.setText("");
            }
        });
    }
}
