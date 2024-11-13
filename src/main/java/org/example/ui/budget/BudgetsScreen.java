package org.example.ui.budget;

import javax.swing.*;
import java.awt.*;

public class BudgetsScreen extends JPanel {

    public BudgetsScreen() {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Budgets", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        // List of budgets and add button
        JPanel budgetListPanel = new JPanel(new BorderLayout());
        JList<String> budgetsList = new JList<>(new String[] {"Budget 1", "Budget 2"});
        JScrollPane scrollPane = new JScrollPane(budgetsList);

        JButton addBudgetButton = new JButton("Add New Budget");
        budgetListPanel.add(scrollPane, BorderLayout.CENTER);
        budgetListPanel.add(addBudgetButton, BorderLayout.SOUTH);

        add(budgetListPanel, BorderLayout.CENTER);
    }
}
