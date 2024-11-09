package org.example.models.tracker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetAccessPK {
    protected long budgetId;
    protected long userId;
}
