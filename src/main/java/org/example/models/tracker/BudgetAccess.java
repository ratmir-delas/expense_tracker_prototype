package org.example.models.tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.example.models.user.User;

@Entity
@IdClass(BudgetAccessPK.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetAccess {

    @Id
    private long budgetId;

    @ManyToOne
    private Budget budget;

    @Id
    private long userId;

    @ManyToOne
    private User user;

    private BudgetAccessLevel accessLevel;

    @ManyToOne
    private User createdBy;

    private long createdById;

    private long createdAt;

}
