package org.example.ui.expense;

import org.example.models.tracker.Expense;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.function.Consumer;

public class ExpenseList extends JPanel {

    private JList<Expense> expenseJList;

    public ExpenseList(List<Expense> expenses, Consumer<Expense> openExpenseForm) {
        setLayout(new BorderLayout());

        expenseJList = new JList<>(new DefaultListModel<>());
        expenseJList.setCellRenderer(new ExpenseListRenderer()); // Use custom renderer
        setExpenseList(expenses);

        JScrollPane scrollPane = new JScrollPane(expenseJList);
        scrollPane.setPreferredSize(new Dimension(400, 300)); // Ensure proper size
        add(scrollPane, BorderLayout.CENTER);

        expenseJList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = expenseJList.locationToIndex(e.getPoint());
                    Expense selectedExpense = expenseJList.getModel().getElementAt(index);
                    openExpenseForm.accept(selectedExpense);
                }
            }
        });
    }

    public void setExpenseList(List<Expense> expenses) {
        DefaultListModel<Expense> model = (DefaultListModel<Expense>) expenseJList.getModel();
        model.clear();
        for (Expense expense : expenses) {
            model.addElement(expense);
        }
    }
}
