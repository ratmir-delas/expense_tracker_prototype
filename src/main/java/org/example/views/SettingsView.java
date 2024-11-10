package org.example.views;

import javax.swing.*;
import java.awt.*;

public class SettingsView extends JPanel {
    public SettingsView() {
        setLayout(new BorderLayout());
        add(new JLabel("Settings View", SwingConstants.CENTER), BorderLayout.CENTER);
    }
}
