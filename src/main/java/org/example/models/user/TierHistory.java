package org.example.models.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TierHistory {

    private long id;

    private long userId;

    private long tierId;

    private long createdAt;

}
