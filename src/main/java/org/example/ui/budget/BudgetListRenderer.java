package org.example.ui.budget;

import org.example.models.tracker.Budget;

import javax.swing.*;
import java.awt.*;

public class BudgetListRenderer extends JPanel implements ListCellRenderer<Budget> {

    private JLabel nameLabel;
    private JLabel amountLabel;
    private JTextArea descriptionArea;

    public BudgetListRenderer() {
        setLayout(new BorderLayout(5, 5));
        nameLabel = new JLabel();
        amountLabel = new JLabel();
        descriptionArea = new JTextArea();
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setOpaque(false);
        descriptionArea.setEditable(false);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(nameLabel, BorderLayout.WEST);
        topPanel.add(amountLabel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);
        add(descriptionArea, BorderLayout.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Budget> list, Budget budget, int index, boolean isSelected, boolean cellHasFocus) {
        nameLabel.setText(budget.getName());
        amountLabel.setText(String.format("$%.2f", budget.getAmount()));
        descriptionArea.setText(budget.getDescription());

        setBackground(isSelected ? Color.LIGHT_GRAY : Color.WHITE);
        setForeground(isSelected ? Color.BLACK : Color.DARK_GRAY);

        return this;
    }
}

