package org.example.models.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.tracker.BudgetAccess;
import org.example.models.tracker.Expense;

import java.util.List;

@Entity
@Table(name = "_user")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private boolean isActive;

    @ManyToOne
    private Tier tier;

    private long createdAt;

    @PrePersist
    protected void onCreate() {
        // set default tier
        this.isActive = true;
        this.createdAt = System.currentTimeMillis();
    }

}
