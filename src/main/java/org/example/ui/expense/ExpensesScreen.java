package org.example.ui.expense;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.example.TrackerApplication;
import org.example.models.tracker.Expense;
import org.example.services.tracker.ExpenseService;
import org.example.ui.MainScreen;
import org.example.util.UserSession;
import org.springframework.context.ApplicationContext;

public class ExpensesScreen extends JPanel {

    private ExpenseList expenseList;
    private JPanel contentPanel;
    private List<Expense> expenses;
    private ExpenseService expenseService;

    public ExpensesScreen(ApplicationContext context, TrackerApplication app) {
        expenseService = context.getBean(ExpenseService.class);
        expenses = expenseService.getPersonalExpensesByUserId(UserSession.getInstance().getUser().getId());
        setLayout(new BorderLayout());

        contentPanel = new JPanel(new BorderLayout());
        expenseList = new ExpenseList(expenses, app::showExpenseForm);
        contentPanel.add(expenseList, BorderLayout.CENTER);
        add(contentPanel, BorderLayout.CENTER);

        JButton addExpenseButton = new JButton("Add New Expense");
        add(addExpenseButton, BorderLayout.SOUTH);

        addExpenseButton.addActionListener(e -> app.showExpenseForm(null));
    }
}
