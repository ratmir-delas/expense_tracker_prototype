package org.example.ui;

import org.example.TrackerApplication;
import org.example.ui.budget.BudgetsScreen;
import org.example.ui.expense.ExpensesScreen;
import org.example.util.UserSession;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JPanel {

    private TrackerApplication app;

    public MainScreen(TrackerApplication app) {
        this.app = app;
        setLayout(new BorderLayout());

        // Left navigation
        JPanel navigationPanel = new JPanel(new GridLayout(4, 1));
        JButton homeButton = new JButton("Home");
        JButton budgetsButton = new JButton("Budgets");
        JButton expensesButton = new JButton("Expenses");
        JButton logoutButton = new JButton("Logout");

        navigationPanel.add(homeButton);
        navigationPanel.add(budgetsButton);
        navigationPanel.add(expensesButton);
        navigationPanel.add(logoutButton);

        add(navigationPanel, BorderLayout.WEST);

        // Central content
        JPanel contentPanel = new JPanel();
        contentPanel.add(new JLabel("Welcome to Expense Tracker!"));
        add(contentPanel, BorderLayout.CENTER);

        // Button actions to load different screens
        homeButton.addActionListener(e -> setContent(contentPanel, new HomeScreen()));
        budgetsButton.addActionListener(e -> setContent(contentPanel, new BudgetsScreen()));
        expensesButton.addActionListener(e -> setContent(contentPanel, new ExpensesScreen()));
        logoutButton.addActionListener(e -> logout());
    }

    private void setContent(JPanel contentPanel, JPanel newScreen) {
        contentPanel.removeAll();
        contentPanel.add(newScreen);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void logout() {
        UserSession.getInstance().setUser(null);
        app.showLoginScreen();
    }
}
