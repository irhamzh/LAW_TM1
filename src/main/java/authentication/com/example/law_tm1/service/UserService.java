package authentication.com.example.law_tm1.service;

import authentication.com.example.law_tm1.model.redis.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    User findUserById(int id);

    List<User> findAllUser();

    void deleteUserById(int id);

    User findUserByUsernameAndPasswordAndClientIdAndClientSecret(String username, String password, String clientId, String clientSecret);
}

