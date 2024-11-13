package org.example.models.tracker;

import jakarta.persistence.*;
import lombok.*;
import org.example.models.user.User;
import org.example.util.UserSession;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Budget {

    @Id
    @GeneratedValue
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
        this.amount = 0;
        this.createdAt = System.currentTimeMillis();
        this.createdBy = UserSession.getInstance().getUser();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = System.currentTimeMillis();
        this.updatedBy = UserSession.getInstance().getUser();
    }

}
