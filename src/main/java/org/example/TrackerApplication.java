package org.example;

import com.formdev.flatlaf.FlatLightLaf;
import org.example.ui.TrackerSplashScreen;
import org.example.ui.auth.LoginScreen;
import org.example.ui.auth.RegisterScreen;
import org.example.ui.MainScreen;
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
        MainScreen mainScreen = new MainScreen(this);

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

    public static void main(String[] args) {

        // Set FlatLaf look and feel
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        ConfigurableApplicationContext context = new SpringApplicationBuilder(TrackerApplication.class).headless(false).run(args);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TrackerApplication app = new TrackerApplication(context);
                app.setVisible(true);
            }
        });
    }
}