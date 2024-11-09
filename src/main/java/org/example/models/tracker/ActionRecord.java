package org.example.models.tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.user.User;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActionRecord {

    @Id
    private long id;

    private ActionType actionType;

    private String objectBefore;

    @ManyToOne
    private Budget budget;

    private long budgetId;

    @ManyToOne
    private Expense expense;

    private long expenseId;

    @ManyToOne
    private User createdBy;

    private long createdById;

    private long createdAt;

}
