package authentication.com.example.law_tm1.controller;

import authentication.com.example.law_tm1.model.redis.User;
import authentication.com.example.law_tm1.response.ErrorResponse;
import authentication.com.example.law_tm1.model.redis.Token;
import authentication.com.example.law_tm1.repository.redis.TokenDao;
import authentication.com.example.law_tm1.response.UserResponse;
import authentication.com.example.law_tm1.service.TokenService;
import authentication.com.example.law_tm1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/oauth")
public class AuthController {

    private static final String AUTHORIZATION_HEADER = "Authorization";

    public static String getBearerTokenHeader() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
    }

    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @PostMapping("/token")
    public ResponseEntity getToken(@RequestParam(value = "username") String username,
                                         @RequestParam(value = "password") String password,
                                         @RequestParam(value = "clientId") String clientId,
                                         @RequestParam(value = "clientSecret") String clientSecret){

        try{
            int userId = userService.findUserByUsernameAndPasswordAndClientIdAndClientSecret(username, password, clientId, clientSecret).getId();
            return new ResponseEntity<>(tokenService.addToken(userId), HttpStatus.OK);
        }catch (NullPointerException e){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setError("invalid_request");
            errorResponse.setErrorDescription("ada kesalahan masbro!");
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(errorResponse);
        }
    }

    @PostMapping("/resource")
    public ResponseEntity getResource(@RequestParam(value = "userId") int userId){
        String headerToken = getBearerTokenHeader().split(" ")[1];
        UserResponse userResponse = new UserResponse();
        LocalDateTime currentTime = LocalDateTime.now();
        try {
            Token token = tokenService.findTokenByUserId(userId);
            if (token.getAccessToken().equals(headerToken)
            && currentTime.isBefore(token.getExpiresIn())
            ){
                User user = userService.findUserById(userId);
                userResponse.setFullName(user.getFullName());
                userResponse.setNpm(user.getNpm());
                userResponse.setClientId(user.getClientId());
                userResponse.setExpires(null);
                userResponse.setAccessToken(token.getAccessToken());
                userResponse.setRefreshToken(token.getRefreshToken());
            }else{
                throw new Exception();
            }
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setError("invalid_token");
            errorResponse.setErrorDescription("token salah masbro!");
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(errorResponse);
        }
    }

}
