package org.example.ui.budget;

import org.example.models.tracker.Budget;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BudgetList extends JPanel {

    private JList<Budget> budgetJList;

    public BudgetList(List<Budget> budgets) {
        setLayout(new BorderLayout());

        budgetJList = new JList<>(new DefaultListModel<>());
        budgetJList.setCellRenderer(new BudgetListRenderer());
        setBudgetList(budgets);

        JScrollPane scrollPane = new JScrollPane(budgetJList);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setBudgetList(List<Budget> budgets) {
        DefaultListModel<Budget> model = (DefaultListModel<Budget>) budgetJList.getModel();
        model.clear();
        for (Budget budget : budgets) {
            model.addElement(budget);
        }
    }
}
