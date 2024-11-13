package org.example.ui.expense;

import javax.swing.*;
import java.awt.*;

public class ExpensesScreen extends JPanel {

    public ExpensesScreen() {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Expenses", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        // List of expenses
        JPanel expenseListPanel = new JPanel(new BorderLayout());
        JList<String> expensesList = new JList<>(new String[] {"Expense 1", "Expense 2"});
        JScrollPane scrollPane = new JScrollPane(expensesList);

        JButton addExpenseButton = new JButton("Add New Expense");
        expenseListPanel.add(scrollPane, BorderLayout.CENTER);
        expenseListPanel.add(addExpenseButton, BorderLayout.SOUTH);

        add(expenseListPanel, BorderLayout.CENTER);
    }
}
