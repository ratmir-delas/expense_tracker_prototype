package org.example.ui.budget;

import java.awt.*;
import javax.swing.*;
import org.example.models.tracker.Budget;
import org.example.services.tracker.BudgetService;
import org.springframework.context.ApplicationContext;

public class BudgetForm extends JPanel {

    private final ApplicationContext context;
    private final Runnable onFormSubmit;
    private Budget budget;

    private JTextField nameField;
    private JTextArea descriptionArea;
    private JButton saveButton;
    private JButton backButton;

    public BudgetForm(ApplicationContext context, Runnable onFormSubmit, Budget budget) {
        this.context = context;
        this.onFormSubmit = onFormSubmit;
        this.budget = budget;

        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Header
        JLabel headerLabel = new JLabel(budget == null ? "Create New Budget" : "Edit Budget");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerLabel, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Name field
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        nameField = new JTextField(budget != null ? budget.getName() : "", 25);
        formPanel.add(nameField, gbc);

        // Description field
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Description:"), gbc);

        gbc.gridx = 1;
        descriptionArea = new JTextArea(budget != null ? budget.getDescription() : "", 4, 25);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane descriptionScroll = new JScrollPane(descriptionArea);
        descriptionScroll.setPreferredSize(new Dimension(200, 80));
        formPanel.add(descriptionScroll, gbc);

        add(formPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        saveButton = new JButton("Save");
        backButton = new JButton("Back");

        buttonPanel.add(backButton);
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Event handling
        saveButton.addActionListener(e -> saveBudget());
        backButton.addActionListener(e -> onFormSubmit.run());
    }

    private void saveBudget() {
        try {
            BudgetService budgetService = context.getBean(BudgetService.class);

            if (budget == null) {
                budget = new Budget();
            }

            budget.setName(nameField.getText().trim());
            budget.setDescription(descriptionArea.getText().trim());

            if (budget.getId() == null) {
                budgetService.create(budget);
            } else {
                budgetService.update(budget);
            }

            onFormSubmit.run();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred while saving the budget.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
