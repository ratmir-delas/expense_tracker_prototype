package org.example.views;

import org.example.service.user.UserService;
import org.example.views.auth.LoginView;
import org.example.views.budget.BudgetListView;
import org.example.views.expense.ExpenseListView;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.prefs.Preferences;

public class MainView extends JFrame {

    private final ApplicationContext context;
    private final UserService userService;
    private final Preferences prefs = Preferences.userNodeForPackage(MainView.class);
    private final JPanel cardPanel = new JPanel(new CardLayout());

    public MainView(ApplicationContext context) {
        this.context = context;
        userService = context.getBean(UserService.class);

        String email = prefs.get("email", null);
        String password = prefs.get("password", null);

        if (email != null && password != null && userService.login(email, password)) {
            initialize();
        } else {
            showLoginView();
        }
    }

    private void initialize() {
        setTitle("Main View");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create navigation panel
        JPanel navPanel = new JPanel(new BorderLayout());
        navPanel.setBorder(BorderFactory.createTitledBorder("Navigation"));
        String[] viewNames = {"Home", "Budgets", "Expenses", "Settings"};
        JList<String> navList = new JList<>(viewNames);
        navList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        navList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedView = navList.getSelectedValue();
                showView(selectedView);
            }
        });
        navPanel.add(new JScrollPane(navList), BorderLayout.CENTER);

        // Add views to card panel
        cardPanel.add(new HomeView(context), "Home");
        cardPanel.add(new BudgetListView(), "Budgets");
        cardPanel.add(new ExpenseListView(), "Expenses");
        cardPanel.add(new SettingsView(), "Settings");

        // Add navigation and card panels to main panel
        mainPanel.add(navPanel, BorderLayout.WEST);
        mainPanel.add(cardPanel, BorderLayout.CENTER);

        // Add main panel to frame
        add(mainPanel);
    }

    private void showView(String viewName) {
        CardLayout cl = (CardLayout) (cardPanel.getLayout());
        cl.show(cardPanel, viewName);
    }

    public void reinitialize() {
        getContentPane().removeAll();
        initialize();
        revalidate();
        repaint();
    }

    private void showLoginView() {
        LoginView loginView = new LoginView(userService, this);
        loginView.setVisible(true);
        this.setVisible(false);
    }
}