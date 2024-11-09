package org.example.models.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.tracker.BudgetAlert;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    private long id;

    private String title;

    private String message;

    @ManyToOne
    private BudgetAlert budgetAlert;

    private long budgetAlertId;

    private long createdAt;

}
