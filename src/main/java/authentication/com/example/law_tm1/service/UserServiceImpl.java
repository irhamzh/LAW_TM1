package authentication.com.example.law_tm1.service;

import authentication.com.example.law_tm1.model.User;
import authentication.com.example.law_tm1.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user){
        int length_id = findAllUser().size();
        user.setId(length_id+1);
        return userDao.save(user);
    }

    @Override
    public User findUserById(int id){
        return userDao.findByUserId(id);
    }

    @Override
    public List<User> findAllUser(){
        return userDao.findAllUser();
    }

    @Override
    public void deleteUserById(int id){
        userDao.delete(id);
    }

    @Override
    public User findUserByUsernameAndPasswordAndClientIdAndClientSecret(String username, String password, String clientId, String clientSecret){
        return userDao.findUserByUsernameAndPassword(username, password, clientId, clientSecret);
    }
}
