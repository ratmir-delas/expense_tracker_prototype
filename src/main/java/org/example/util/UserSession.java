package org.example.util;

import lombok.Getter;
import lombok.Setter;
import org.example.models.user.User;

@Setter
@Getter
public class UserSession {

    private static UserSession instance;
    private User user;

    private UserSession() {
        // Private constructor to prevent instantiation
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void clear() {
        user = null;
    }
}