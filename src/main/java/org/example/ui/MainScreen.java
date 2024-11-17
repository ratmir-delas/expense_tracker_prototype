package org.example.ui;

import org.example.TrackerApplication;
import org.example.models.tracker.Budget;
import org.example.models.tracker.Expense;
import org.example.ui.budget.BudgetForm;
import org.example.ui.budget.BudgetsScreen;
import org.example.ui.expense.ExpenseForm;
import org.example.ui.expense.ExpensesScreen;
import org.example.util.UserSession;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JPanel {

    private TrackerApplication app;
    private ApplicationContext context;
    private JPanel contentPanel;
    private JPanel currentScreen; // Keep track of the currently displayed screen

    public MainScreen(TrackerApplication app, ApplicationContext context) {
        this.app = app;
        this.context = context;
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
        contentPanel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome to Expense Tracker!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contentPanel.add(welcomeLabel, BorderLayout.CENTER);
        add(contentPanel, BorderLayout.CENTER);

        currentScreen = contentPanel; // Initialize with the default screen

        // Button actions to load different screens
        homeButton.addActionListener(e -> setContent(new HomeScreen()));
        budgetsButton.addActionListener(e -> setContent(new BudgetsScreen(context, app)));
        expensesButton.addActionListener(e -> setContent(new ExpensesScreen(context, app)));
        logoutButton.addActionListener(e -> logout());
    }

    private void setContent(JPanel newScreen) {
        // Only update the content if the new screen is different from the current one
        if (currentScreen != newScreen) {
            contentPanel.removeAll();
            contentPanel.add(newScreen, BorderLayout.CENTER);
            contentPanel.revalidate();
            contentPanel.repaint();
            currentScreen = newScreen; // Update the currently displayed screen
        }
    }

    private void logout() {
        UserSession.getInstance().setUser(null);
        app.restart();
    }
}
