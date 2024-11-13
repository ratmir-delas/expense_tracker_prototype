package org.example.models.user;

import jakarta.persistence.*;
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
    @GeneratedValue
    private Long id;

    private ActionType actionType;

    @Column(name = "`limit`")
    private int limit;

    @ManyToOne
    private Tier tier;

}
