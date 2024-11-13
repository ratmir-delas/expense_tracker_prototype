package org.example.ui.auth;

import org.example.models.user.User;
import org.example.service.user.UserService;
import org.example.util.UserSession;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class LoginScreen extends JPanel {

    private Runnable onLoginSuccess;
    private Runnable showRegisterScreen;
    private UserService userService;

    public LoginScreen(ApplicationContext context, Runnable onLoginSuccess, Runnable showRegisterScreen) {
        this.userService = context.getBean(UserService.class);
        this.onLoginSuccess = onLoginSuccess;
        this.showRegisterScreen = showRegisterScreen;
        initLogin();
    }

    private void initLogin() {
        setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel("Login", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        formPanel.add(userLabel);
        formPanel.add(userField);
        formPanel.add(passLabel);
        formPanel.add(passField);
        formPanel.add(new JPanel());
        formPanel.add(loginButton);

        add(formPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        JButton registerButton = new JButton("Register");
        bottomPanel.add(registerButton);
        add(bottomPanel, BorderLayout.SOUTH);

        registerButton.addActionListener(e -> showRegisterScreen.run());

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Sample authentication check
                //"user".equals(userField.getText()) && "password".equals(new String(passField.getPassword()))
                String email = userField.getText();
                String password = new String(passField.getPassword());
                Optional<User> user;

                // verify fields are not empty
                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // verify login credentials
                if (userService.login(email, password)) {
                    user = userService.getUserByEmail(email);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                UserSession.getInstance().setUser(user.get());
                onLoginSuccess.run(); // Call the main screen callback on successful login

                // clear fields
                userField.setText("");
                passField.setText("");
            }
        });
    }
}
