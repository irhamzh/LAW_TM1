package authentication.com.example.law_tm1.repository;

import authentication.com.example.law_tm1.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TokenDao {
    public static final String HASH_KEY = "Token";

    @Autowired
    private RedisTemplate template;

    public Token save(Token token){
        template.opsForHash().put(HASH_KEY, token.getId(), token);
        return token;
    }

    public Token findTokenByUserId(int userId) {
        List<Token> tokenList = findAllToken();
        for (Token token : tokenList){
            if (token.getUserId() == userId){
                return token;
            }
        }
        return null;
    }

    public Token findTokenById(int id) {return (Token) template.opsForHash().get(HASH_KEY, id);}

    public List<Token> findAllToken(){return template.opsForHash().values(HASH_KEY);}
}
