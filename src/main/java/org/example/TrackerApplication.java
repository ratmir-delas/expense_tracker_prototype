package org.example;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import org.example.models.tracker.Budget;
import org.example.models.tracker.Expense;
import org.example.ui.TrackerSplashScreen;
import org.example.ui.auth.LoginScreen;
import org.example.ui.auth.RegisterScreen;
import org.example.ui.MainScreen;
import org.example.ui.budget.BudgetForm;
import org.example.ui.expense.ExpenseForm;
import org.example.util.UserSession;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class TrackerApplication extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private ApplicationContext context;

    public static final String SPLASH_SCREEN = "SplashScreen";
    public static final String LOGIN_SCREEN = "LoginScreen";
    public static final String REGISTER_SCREEN = "RegisterScreen";
    public static final String MAIN_SCREEN = "MainScreen";
    public static final String BUDGET_FORM_SCREEN = "BudgetFormScreen";
    public static final String EXPENSE_FORM_SCREEN = "ExpenseFormScreen";

    public TrackerApplication(ApplicationContext context) {
        this.context = context;
        initUI();
    }

    private void initUI() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Initialize screens with transition callbacks
        TrackerSplashScreen splashScreen = new TrackerSplashScreen(this::checkAuthorization);
        LoginScreen loginScreen = new LoginScreen(context, this::showMainScreen, this::showRegisterScreen);
        RegisterScreen registerScreen = new RegisterScreen(context, this::showMainScreen, this::showLoginScreen);
        MainScreen mainScreen = new MainScreen(this, context);

        // Add screens to main panel with CardLayout
        mainPanel.add(splashScreen, SPLASH_SCREEN);
        mainPanel.add(loginScreen, LOGIN_SCREEN);
        mainPanel.add(registerScreen, REGISTER_SCREEN);
        mainPanel.add(mainScreen, MAIN_SCREEN);

        // Set up frame with main panel
        add(mainPanel);
        setTitle("Expense Tracker");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Start with Splash Screen
        showSplashScreen();
    }

    public void showSplashScreen() {
        cardLayout.show(mainPanel, SPLASH_SCREEN);
    }

    public void checkAuthorization() {
        if (UserSession.getInstance().getUser() != null) {
            showMainScreen();
        } else {
            showLoginScreen();
        }
    }

    public void showLoginScreen() {
        cardLayout.show(mainPanel, LOGIN_SCREEN);
    }

    public void showRegisterScreen() {
        cardLayout.show(mainPanel, REGISTER_SCREEN);
    }

    public void showMainScreen() {
        cardLayout.show(mainPanel, MAIN_SCREEN);
    }

    public void showBudgetForm(Budget budget) {
        BudgetForm budgetForm = new BudgetForm(context, this::showMainScreen, budget);
        mainPanel.add(budgetForm, BUDGET_FORM_SCREEN);
        cardLayout.show(mainPanel, BUDGET_FORM_SCREEN);
    }

    public void showExpenseForm(Expense expense) {
        ExpenseForm expenseForm = new ExpenseForm(context, this::showMainScreen, expense);
        mainPanel.add(expenseForm, EXPENSE_FORM_SCREEN);
        cardLayout.show(mainPanel, EXPENSE_FORM_SCREEN);
    }

    public void restart() {
        mainPanel.removeAll();
        initUI();
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        // Set FlatLaf look and feel
        UIManager.setLookAndFeel(new FlatLightLaf());

        FlatLaf.registerCustomDefaultsSource("com.example.theme.custom");

        final int rounding = 8;
        final int insets = 2;

        UIManager.put("CheckBox.icon.style", "filled");
        UIManager.put("Component.arrowType", "chevron");

        UIManager.put("Component.focusWidth", 1);
        UIManager.put("Component.innerFocusWidth", 1);

        UIManager.put("Button.arc", rounding);
        UIManager.put("Component.arc", rounding);
        UIManager.put("ProgressBar.arc", rounding);
        UIManager.put("TextComponent.arc", rounding);

        UIManager.put("ScrollBar.thumbArc", rounding);
        UIManager.put("ScrollBar.thumbInsets", new Insets(insets, insets, insets, insets));

        ConfigurableApplicationContext context = new SpringApplicationBuilder(TrackerApplication.class).headless(false).run(args);

        SwingUtilities.invokeLater(() -> {
            TrackerApplication app = new TrackerApplication(context);
            app.setVisible(true);
        });
    }

}