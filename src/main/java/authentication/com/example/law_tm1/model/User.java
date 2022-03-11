package authentication.com.example.law_tm1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("User")
public class User implements Serializable {
    @Id
    private int id;

    @Indexed
    private String username;

    @Indexed
    private String password;

    private String fullName;
    private String npm;
    private String clientId;
    private String clientSecret;
}
