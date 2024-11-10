package org.example.models.tracker;

import jakarta.persistence.*;
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
    private Long id;

    private double amount;

    private long dateTime;

    private String description;

    @Enumerated
    private ExpenseCategory expenseCategory;

    @ManyToOne
    private Budget budget;

    @ManyToOne
    private User updatedBy;

    private long updatedAt;

    @ManyToOne
    private User createdBy;

    private long createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = System.currentTimeMillis();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = System.currentTimeMillis();
    }

}
