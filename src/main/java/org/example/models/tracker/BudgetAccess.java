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
public class BudgetAccess {

    @Id
    @GeneratedValue
    private Long id;

    private BudgetAccessLevel accessLevel;

    @ManyToOne
    private Budget budget;

    @ManyToOne
    private User user;

    @ManyToOne
    private User createdBy;

    private long createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = System.currentTimeMillis();
        this.createdBy = UserSession.getInstance().getUser();
    }

}
