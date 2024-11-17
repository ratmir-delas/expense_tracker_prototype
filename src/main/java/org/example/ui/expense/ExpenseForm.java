package org.example.ui.expense;

import org.example.models.tracker.Expense;
import org.example.models.tracker.ExpenseCategory;
import org.example.services.tracker.ExpenseService;
import org.jdesktop.swingx.JXDatePicker;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpenseForm extends JPanel {

    private ApplicationContext context;
    private Runnable onFormSubmit;
    private Expense expense;
    private JComboBox<ExpenseCategory> categoryComboBox;
    private JTextField amountField;
    private JXDatePicker datePicker;
    private JButton saveButton;
    private JButton backButton;

    public ExpenseForm(ApplicationContext context, Runnable onFormSubmit, Expense expense) {
        this.context = context;
        this.onFormSubmit = onFormSubmit;
        this.expense = expense;

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        formPanel.add(new JLabel("Category:"));
        categoryComboBox = new JComboBox<>(ExpenseCategory.values());
        if (expense != null) {
            categoryComboBox.setSelectedItem(expense.getCategory());
        }
        formPanel.add(categoryComboBox);

        formPanel.add(new JLabel("Amount:"));
        amountField = new JTextField(expense != null ? String.valueOf(expense.getAmount()) : "");
        formPanel.add(amountField);

        add(formPanel, BorderLayout.CENTER);

        formPanel.add(new JLabel("Date:"));
        datePicker = new JXDatePicker();
        datePicker.setDate(expense != null ? expense.getDate() : new java.util.Date());
        formPanel.add(datePicker);

        JPanel buttonPanel = new JPanel();
        saveButton = new JButton("Save");
        backButton = new JButton("Go Back");

        buttonPanel.add(saveButton);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(e -> saveExpense());

        backButton.addActionListener(e -> onFormSubmit.run());
    }

    private void saveExpense() {
        ExpenseService expenseService = context.getBean(ExpenseService.class);
        if (expense == null) {
            expense = new Expense();
        }
        expense.setCategory((ExpenseCategory) categoryComboBox.getSelectedItem());
        expense.setAmount(Double.parseDouble(amountField.getText()));
        expense.setDate(datePicker.getDate());
        expenseService.create(expense);
        onFormSubmit.run();
    }
}
