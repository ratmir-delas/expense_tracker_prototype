package org.example.models.assistance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketReply {

    private long id;

    private String body;

    private long ticketId;

    private long createdBy;

    private long createdAt;

}
