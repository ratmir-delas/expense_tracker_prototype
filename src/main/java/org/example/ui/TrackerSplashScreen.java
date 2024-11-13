package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TrackerSplashScreen extends JPanel {

    private Runnable onComplete;

    public TrackerSplashScreen(Runnable onComplete) {
        this.onComplete = onComplete;
        initSplash();
        showSplash();
    }

    private void initSplash() {
        setLayout(new BorderLayout());
        JLabel splashLabel = new JLabel("Welcome to Expense Tracker", JLabel.CENTER);
        splashLabel.setFont(new Font("Arial", Font.BOLD, 32));
        add(splashLabel, BorderLayout.CENTER);
        setBackground(Color.WHITE);
    }

    private void showSplash() {
        // Display splash screen for 2 seconds before proceeding
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(onComplete); // Calls the checkAuthorization callback
            }
        }, 2000); // 2000 ms delay
    }
}
