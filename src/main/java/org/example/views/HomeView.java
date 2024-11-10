package org.example.views;

import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JPanel {

    private final ApplicationContext context;

    public HomeView(ApplicationContext context) {
        this.context = context;
        initialize();
    }

    private void initialize() {
        setSize(800, 600);

        // Create main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create side panel for settings and profile
        JPanel sidePanel = new JPanel(new GridLayout(2, 1));
        sidePanel.add(new JLabel("Settings"));
        sidePanel.add(new JLabel("My Profile"));

        // Create center panel for budgets and expenses
        JPanel centerPanel = new JPanel(new GridLayout(2, 1));

        // Create budgets panel
        JPanel budgetsPanel = new JPanel(new BorderLayout());
        budgetsPanel.setBorder(BorderFactory.createTitledBorder("Budgets"));
        JList<String> budgetsList = new JList<>(new String[]{"Budget 1", "Budget 2"}); // Example data
        JButton addBudgetButton = new JButton("Add Budget");
        budgetsPanel.add(new JScrollPane(budgetsList), BorderLayout.CENTER);
        budgetsPanel.add(addBudgetButton, BorderLayout.SOUTH);

        // Create expenses panel
        JPanel expensesPanel = new JPanel(new BorderLayout());
        expensesPanel.setBorder(BorderFactory.createTitledBorder("Personal Expenses"));
        JList<String> expensesList = new JList<>(new String[]{"Expense 1", "Expense 2"}); // Example data
        JButton addExpenseButton = new JButton("Add Expense");
        expensesPanel.add(new JScrollPane(expensesList), BorderLayout.CENTER);
        expensesPanel.add(addExpenseButton, BorderLayout.SOUTH);

        // Add budgets and expenses panels to center panel
        centerPanel.add(budgetsPanel);
        centerPanel.add(expensesPanel);

        // Add side and center panels to main panel
        mainPanel.add(sidePanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Add main panel to frame
        add(mainPanel);
    }
}
