package org.example.models.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;

    private long tierId;

    private String name;

    private String email;

    private String password;

    private boolean isActive;

    private long createdAt;

}
