package commands;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Message extends ChatCommand {
    private LocalDateTime timestamp;
    private String content;

    /**
     * Default constructor for various frameworks
     */
    protected Message() {
    }

    public static Message createNew(String content) {
        return load(LocalDateTime.now(), content);
    }

    public static Message load(LocalDateTime timestamp, String content) {
        Message message = new Message();
        message.timestamp = timestamp;
        message.content = content;
        return message;
    }
}