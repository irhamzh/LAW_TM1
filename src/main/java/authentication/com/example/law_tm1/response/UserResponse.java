package authentication.com.example.law_tm1.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    String fullName;
    String npm;
    String clientId;
    String expires;
    String accessToken;
    String refreshToken;
}
