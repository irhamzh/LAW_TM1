package authentication.com.example.law_tm1.service;

import authentication.com.example.law_tm1.model.redis.Token;
import authentication.com.example.law_tm1.repository.redis.TokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TokenServiceImpl implements TokenService{
    @Autowired
    private TokenDao tokenDao;

    @Override
    public Token addToken(int userId){
        Token token = new Token();
        LocalDateTime currentTime = LocalDateTime.now();
        if (findTokenByUserId(userId) != null){
            token = findTokenByUserId(userId);
            if (currentTime.isAfter(token.getExpiresIn())){
                token.setAccessToken(generateToken());
                token.setRefreshToken(generateToken());
                token.setExpiresIn(currentTime.plusSeconds(300));
            }else{
                return token;
            }
        }else{
            token.setId(findAllToken().size()+1);
            token.setUserId(userId);
            token.setAccessToken(generateToken());
            token.setRefreshToken(generateToken());
            token.setTokenType("Bearer");
            token.setScope(null);
            token.setExpiresIn(currentTime.plusSeconds(300));
        }
        return tokenDao.save(token);
    }

    @Override
    public List<Token> findAllToken(){
        return tokenDao.findAllToken();
    }

    @Override
    public Token findTokenByUserId(int userId){
        return tokenDao.findTokenByUserId(userId);
    }

    @Override
    public Token findTokenById(int id) { return tokenDao.findTokenById(id);}

    @Override
    public Token updateToken(Token token){
        return token;
    }

    public String generateToken(){
        String AB = "0123456789abcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(40);
        for(int i = 0; i < 40; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

}
