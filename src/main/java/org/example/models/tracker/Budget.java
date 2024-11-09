package org.example.models.tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private long id;

    private String name;

    private String description;

    private double amount;

    @ManyToOne
    private User createdBy;

    private long createdById;

    private long createdAt;

    @ManyToOne
    private User updatedBy;

    private long updatedById;

    private long updatedAt;

    @OneToMany
    private List<BudgetAccess> participants;

}
