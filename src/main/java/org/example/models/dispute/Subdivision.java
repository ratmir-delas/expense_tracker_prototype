package org.example.models.dispute;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subdivision {

    private long id;

    private double amount;

    private double percentage;

    private long expenseId;

    private long disputeId;

    private long userId;

    private long createdById;

}
