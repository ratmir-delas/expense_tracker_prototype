package org.example.ui.expense;

import org.example.models.tracker.Expense;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ExpenseList extends JPanel {

    private JList<Expense> expenseJList;

    public ExpenseList(List<Expense> expenses) {
        setLayout(new BorderLayout());

        expenseJList = new JList<>(new DefaultListModel<>());
        expenseJList.setCellRenderer(new ExpenseListRenderer());
        setExpenseList(expenses);

        JScrollPane scrollPane = new JScrollPane(expenseJList);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setExpenseList(List<Expense> expenses) {
        DefaultListModel<Expense> model = (DefaultListModel<Expense>) expenseJList.getModel();
        model.clear();
        for (Expense expense : expenses) {
            model.addElement(expense);
        }
    }
}
