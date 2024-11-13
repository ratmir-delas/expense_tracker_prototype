package org.example.ui.expense;

import org.example.models.tracker.Expense;

import javax.swing.*;
import java.awt.*;

public class ExpenseListRenderer extends JPanel implements ListCellRenderer<Expense> {

    private JLabel amountLabel;
    private JLabel categoryLabel;
    private JLabel dateLabel;

    public ExpenseListRenderer() {
        setLayout(new BorderLayout(5, 5));
        amountLabel = new JLabel();
        categoryLabel = new JLabel();
        dateLabel = new JLabel();

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(amountLabel, BorderLayout.EAST);
        topPanel.add(categoryLabel, BorderLayout.WEST);

        add(topPanel, BorderLayout.NORTH);
        add(dateLabel, BorderLayout.SOUTH);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Expense> list, Expense expense, int index, boolean isSelected, boolean cellHasFocus) {
        amountLabel.setText(String.format("%.2f€", expense.getAmount()));
        categoryLabel.setText(expense.getCategory().name());
        dateLabel.setText(Long.toString(expense.getDateTime()));

        setBackground(isSelected ? Color.LIGHT_GRAY : Color.WHITE);
        setForeground(isSelected ? Color.BLACK : Color.DARK_GRAY);

        return this;
    }
}
