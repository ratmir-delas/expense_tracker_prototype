package org.example.ui.budget;

import org.example.models.tracker.Budget;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.function.Consumer;

public class BudgetList extends JPanel {

    private JList<Budget> budgetJList;

    public BudgetList(List<Budget> budgets, Consumer<Budget> openBudgetForm) {
        setLayout(new BorderLayout());

        budgetJList = new JList<>(new DefaultListModel<>());
        budgetJList.setCellRenderer(new BudgetListRenderer()); // Use custom renderer
        setBudgetList(budgets);

        JScrollPane scrollPane = new JScrollPane(budgetJList);
        add(scrollPane, BorderLayout.CENTER);

        // Add double-click listener to open the budget form in edit mode
        budgetJList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = budgetJList.locationToIndex(e.getPoint());
                    Budget selectedBudget = budgetJList.getModel().getElementAt(index);
                    openBudgetForm.accept(selectedBudget);
                }
            }
        });
    }

    public void setBudgetList(List<Budget> budgets) {
        DefaultListModel<Budget> model = (DefaultListModel<Budget>) budgetJList.getModel();
        model.clear();
        for (Budget budget : budgets) {
            model.addElement(budget);
        }
    }
}
