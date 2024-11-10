package org.example.models.tracker;

import jakarta.persistence.*;
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
//    @Column(name = "budget_id")
    private Long budgetId;

    @Id
//    @Column(name = "user_id")
    private Long userId;

    private BudgetAccessLevel accessLevel;

    @ManyToOne
    private User createdBy;

    private long createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = System.currentTimeMillis();
    }

}
