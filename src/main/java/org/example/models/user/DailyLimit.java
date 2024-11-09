package org.example.models.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.tracker.ActionType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyLimit {

    private long tierId;

    private ActionType actionType;

    private int limit;

}
