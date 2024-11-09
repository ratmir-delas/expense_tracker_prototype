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
public class BudgetAlert {

    @Id
    private long id;

    private double amount;

    private boolean notifyEveryone;

    @ManyToOne
    private Budget budget;

    private long budgetId;

    @ManyToOne
    private User createdBy;

    private long createdById;

}
