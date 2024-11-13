package org.example.ui;

import javax.swing.*;
import java.awt.*;

public class HomeScreen extends JPanel {

    public HomeScreen() {
        setLayout(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome to the Home Screen!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(welcomeLabel, BorderLayout.CENTER);
    }
}
