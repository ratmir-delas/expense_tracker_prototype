package org.example.views.auth;

import org.example.service.user.UserService;
import org.example.views.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame {

    private final UserService userService;
    private final MainView mainView;

    public RegisterView(UserService userService, MainView mainView) {
        this.userService = userService;
        this.mainView = mainView;

        setTitle("Register View");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create registration form components
        JPanel panel = new JPanel(new GridLayout(4, 2));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton registerButton = new JButton("Register");

        // Add components to the panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Empty cell
        panel.add(registerButton);

        // Add panel to the frame
        add(panel, BorderLayout.CENTER);

        // Add action listener to the register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Perform registration logic using userService
                if (userService.register(name, email, password)) {
                    // If registration is successful, reinitialize and open the main view
                    mainView.reinitialize();
                    mainView.setVisible(true);
                    dispose(); // Close the register view
                } else {
                    // Show error message
                    JOptionPane.showMessageDialog(RegisterView.this, "Registration failed", "Register Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}