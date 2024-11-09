package org.example.models.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private long id;

    private String name;

    private String email;

    private String password;

    private boolean isActive;

    @ManyToOne
    private Tier tier;

    private long tierId;

    private long createdAt;

}
