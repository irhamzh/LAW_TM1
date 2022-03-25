package authentication.com.example.law_tm1.repository.redis;

import authentication.com.example.law_tm1.model.redis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    public static final String HASH_KEY = "User";

    @Autowired
    private RedisTemplate template;

    public User save(User user){
        template.opsForHash().put(HASH_KEY, user.getId(), user);
        return user;
    }

    public User findByUserId(int id){
        return (User) template.opsForHash().get(HASH_KEY, id);
    }

    public List<User> findAllUser(){return template.opsForHash().values(HASH_KEY);}

    public void delete(int id){
        template.opsForHash().delete(HASH_KEY, id);
    }

//    public User findUserByUsernameAndPassword(String username, String password){
//        return (User) template.opsForHash().multiGet(HASH_KEY, Arrays.asList(username, password));
//    }

    public User findUserByUsernameAndPassword(String username, String password,
                                              String clientId, String clientSecret){
        List<User> allUser = findAllUser();

        for (User user : allUser) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) &&
            user.getClientId().equals(clientId) && user.getClientSecret().equals(clientSecret)) {
                return user;
            }
        }
        return null;
    }
}
