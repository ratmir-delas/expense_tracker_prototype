package org.example.models.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    private long id;

    private long userId;

    private long budgetAlertId;

    private String title;

    private String message;

    private boolean isRead;

    private long createdAt;

}
