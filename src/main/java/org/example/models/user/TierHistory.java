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
public class TierHistory {

    @Id
    private long id;

    @ManyToOne
    private User user;

    private long userId;

    @ManyToOne
    private Tier tier;

    private long tierId;

    private long createdAt;

}
