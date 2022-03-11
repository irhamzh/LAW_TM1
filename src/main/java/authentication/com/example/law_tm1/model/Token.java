package authentication.com.example.law_tm1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Token")
public class Token implements Serializable {
    private static final long serialVersionUID = -6808244876988745356L;

    @Id
    private int id;

    @Indexed
    private int userId;

    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private String scope;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expiresIn;
}
