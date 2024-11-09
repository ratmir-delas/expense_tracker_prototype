package org.example.models.assistance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    private long id;

    private String title;

    private String body;

    private long assistantId;

    private long createdBy;

    private long createdAt;

}
