package org.example.models.tracker;

import jakarta.persistence.*;
import lombok.*;
import org.example.models.user.User;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Budget {

    @Id
    private Long id;

    private String name;

    private String description;

    private double amount;

    @ManyToOne
    private User createdBy;

    private long createdAt;

    @ManyToOne
    private User updatedBy;

    private long updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = System.currentTimeMillis();
    }

    @OneToMany
    private List<BudgetAccess> participants;

}
