package org.example.views.expense;

import javax.swing.*;
import java.awt.*;

public class ExpenseListView extends JPanel {
    public ExpenseListView() {
        setLayout(new BorderLayout());
        add(new JLabel("Expense List View", SwingConstants.CENTER), BorderLayout.CENTER);
    }
}
