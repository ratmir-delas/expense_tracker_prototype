package org.example.models.tracker;

import lombok.*;
import org.example.models.user.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Expense {

    private long id;

    private double amount;

    private long dateTime;

    private String description;

    private ExpenseCategory expenseCategory;

    // foreign key
    private long budgetId;

    private Budget budget;

    // foreign key
    private long createdById;

    private User createdBy;

    private long createdAt;

    // foreign key
    private long updatedById;

    private User updatedBy;

    private long updatedAt;

    // lazy loading

    private void loadBudget() {

    }

    private void loadCreatedBy() {

    }

    private void loadUpdatedBy() {

    }

    public Budget getBudget() {
        if (budget == null) {
            loadBudget();
        }
        return budget;
    }

    public User getCreatedBy() {
        if (createdBy == null) {
            loadCreatedBy();
        }
        return createdBy;
    }

    public User getUpdatedBy() {
        if (updatedBy == null) {
            loadUpdatedBy();
        }
        return updatedBy;
    }

}
