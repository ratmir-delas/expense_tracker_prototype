package org.example.models.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.tracker.ActionType;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyLimit {

    @Id
    private long id;

    private ActionType actionType;

    private int limit;

    @ManyToOne
    private Tier tier;

    private long tierId;

}
