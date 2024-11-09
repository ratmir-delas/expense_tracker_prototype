package org.example.models.tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.example.models.user.User;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Expense {

    @Id
    private long id;

    private double amount;

    private long dateTime;

    private String description;

    @Enumerated
    private ExpenseCategory expenseCategory;

    @ManyToOne
    private Budget budget;

    private long budgetId;

    @ManyToOne
    private User updatedBy;

    private long updatedById;

    private long updatedAt;

    @ManyToOne
    private User createdBy;

    private long createdById;

    private long createdAt;

}
