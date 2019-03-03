import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class User {
    public static final int MIN_USERNAME_LENGHT = 4;
    public static final int MAX_USERNAME_LENGHT = 20;

    private UUID id;
    private String username;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(String username, String password) {
        id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    public void changeUsername(String username){
        if (!isUsernameValid(username)) {
            throw new IllegalArgumentException("Valid username should have " +
                    "a lenght between " + MIN_USERNAME_LENGHT +
                    " and " + MAX_USERNAME_LENGHT);
        }
        this.username = username;

    }

    public static boolean isUsernameValid (String username) {
        return username != null &&
                username.length() >= MIN_USERNAME_LENGHT &&
                username.length() <= MAX_USERNAME_LENGHT;
    }
    private void update(){
        updatedAt = LocalDateTime.now();
    }

}
