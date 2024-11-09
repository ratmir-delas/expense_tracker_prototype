package org.example.models.dispute;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dispute {

    private long id;

    private DisputeReason disputeReason;

    private DisputeStatus disputeStatus;

    private String description;

    private long createdAt;

    private long updatedAt;

    private long resolvedAt;

    private long expenseId;

}
