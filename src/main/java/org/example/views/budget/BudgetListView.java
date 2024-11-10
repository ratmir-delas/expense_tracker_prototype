package org.example.views.budget;

import javax.swing.*;
import java.awt.*;

public class BudgetListView extends JPanel {
    public BudgetListView() {
        setLayout(new BorderLayout());
        add(new JLabel("Budget List View", SwingConstants.CENTER), BorderLayout.CENTER);
    }
}
