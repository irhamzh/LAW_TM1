package authentication.com.example.law_tm1.service;

import authentication.com.example.law_tm1.model.Token;

import java.util.List;

public interface TokenService {
    Token addToken(int userId);

    Token findTokenByUserId(int userId);

    Token findTokenById(int id);

    List<Token> findAllToken();

    Token updateToken(Token token);

}
