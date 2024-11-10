package org.example.service.user;

import org.example.models.user.Tier;
import org.example.models.user.User;

public interface UserService {

    boolean register(String name, String email, String password);

    boolean login(String email, String password);

    boolean changePassword(String email, String oldPassword, String newPassword);

    boolean updateTier(User user, Tier tier);

    boolean delete(User user);

}
