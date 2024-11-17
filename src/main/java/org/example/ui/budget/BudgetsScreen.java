package org.example.ui.budget;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.example.TrackerApplication;
import org.example.models.tracker.Budget;
import org.example.services.tracker.BudgetService;
import org.example.ui.MainScreen;
import org.example.util.UserSession;
import org.springframework.context.ApplicationContext;

public class BudgetsScreen extends JPanel {

    private BudgetList budgetList;
    private JPanel contentPanel;
    private List<Budget> budgets;
    private BudgetService budgetService;

    public BudgetsScreen(ApplicationContext context, TrackerApplication app) {
        budgetService = context.getBean(BudgetService.class);
        budgets = budgetService.getAllByUserId(UserSession.getInstance().getUser().getId());
        setLayout(new BorderLayout());

        contentPanel = new JPanel(new BorderLayout());
        budgetList = new BudgetList(budgets, app::showBudgetForm);
        contentPanel.add(budgetList, BorderLayout.CENTER);
        add(contentPanel, BorderLayout.CENTER);

        JButton addBudgetButton = new JButton("Add New Budget");
        add(addBudgetButton, BorderLayout.SOUTH);

        addBudgetButton.addActionListener(e -> app.showBudgetForm(null));
    }
}
