package org.example.views.auth;

import org.example.service.user.UserService;
import org.example.views.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

public class LoginView extends JFrame {

    private final UserService userService;
    private final MainView mainView;
    private final Preferences prefs = Preferences.userNodeForPackage(LoginView.class);

    public LoginView(UserService userService, MainView mainView) {
        this.userService = userService;
        this.mainView = mainView;

        setTitle("Login View");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create login form components
        JPanel panel = new JPanel(new GridLayout(5, 2));
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JLabel registerLabel = new JLabel("Don't have an account?");
        JButton registerButton = new JButton("Register here");

        // Add components to the panel
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Empty cell
        panel.add(loginButton);
        panel.add(new JLabel()); // Empty cell
        panel.add(registerLabel);
        panel.add(new JLabel()); // Empty cell
        panel.add(registerButton);

        // Add panel to the frame
        add(panel, BorderLayout.CENTER);

        // Add action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Perform login logic using userService
                if (userService.login(email, password)) {
                    // Save credentials in preferences
                    prefs.put("email", email);
                    prefs.put("password", password);

                    // If login is successful, reinitialize and open the main view
                    mainView.reinitialize();
                    mainView.setVisible(true);
                    dispose(); // Close the login view
                } else {
                    // Show error message
                    JOptionPane.showMessageDialog(LoginView.this, "Invalid email or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add action listener to the register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterView registerView = new RegisterView(userService, mainView);
                mainView.setVisible(false); // Hide the main view before showing the register view
                registerView.setVisible(true);
                dispose(); // Close the login view
            }
        });
    }
}