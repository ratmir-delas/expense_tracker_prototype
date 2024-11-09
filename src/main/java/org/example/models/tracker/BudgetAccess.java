package org.example.models.tracker;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BudgetAccess {

    private long budgetId;

    private long userId;

    private BudgetAccessLevel accessLevel;

}
