package org.example.models.tracker;

import jakarta.persistence.*;
import lombok.*;
import org.example.models.user.User;
import org.example.util.UserSession;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Expense {

    @Id
    @GeneratedValue
    private Long id;

    private double amount;

    private long dateTime;

    private String description;

    @Enumerated
    private ExpenseCategory category;

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
        if (this.category == null) {
            this.category = ExpenseCategory.OTHER;
        }
        this.createdAt = System.currentTimeMillis();
        this.createdBy = UserSession.getInstance().getUser();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = System.currentTimeMillis();
        this.updatedBy = UserSession.getInstance().getUser();
    }

}
