package org.example.service.user;

import org.example.models.user.User;

public class UserServiceImpl implements UserService {

    @Override
    public boolean register(String name, String email, String password) {
        return false;
    }

    @Override
    public boolean authenticate(String email, String password) {
        return false;
    }

    @Override
    public boolean changePassword(String email, String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public boolean updateTier(User user) {
        return false;
    }

    @Override
    public boolean delete(String email) {
        return false;
    }
}
