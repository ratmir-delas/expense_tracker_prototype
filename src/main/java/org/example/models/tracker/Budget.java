package org.example.models.tracker;

import lombok.*;
import org.example.models.user.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Budget {

    private long id;

    private String name;

    private String description;

    private double amount;

    // foreign key
    private long createdById;

    private User createdBy;

    // foreign key
    private long updatedById;

    private User updatedBy;

    private long updatedAt;




}
