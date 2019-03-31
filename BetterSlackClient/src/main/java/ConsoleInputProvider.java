import com.beust.jcommander.JCommander;
import commands.ChatCommand;
import commands.ChatCommandFactory;
import commands.Message;
import commands.SupportedCommands;
import exceptions.EmptyMessageException;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleInputProvider implements UserInputProvider {
    private final Scanner scanner = new Scanner(System.in);
    private final ChatCommandFactory chatCommandFactory = new ChatCommandFactory();

    public ConsoleInputProvider() {
    }

    @Override
    public ChatCommand getUserInput() {
        String input = scanner.nextLine();

        if(input.trim().isEmpty()) {
            throw new EmptyMessageException();
        }

        if(isCommand(input)) {
            String commandString = input.contains(" ")
                    ? input.split(" ")[0]
                    : input;

            SupportedCommands commandType = SupportedCommands.fromString(commandString);
            ChatCommand command =  chatCommandFactory.create(commandType);

            if(input.contains(" ")) {
                String[] arguments = input.split(" ");
                JCommander.newBuilder()
                        .addObject(command)
                        .build()
                        .parse(Arrays.copyOfRange(arguments, 1, arguments.length));
            }

            return command;
        }

        return Message.createNew(input);
    }

    private static boolean isUsernameValid(String username) {
        return !username.isEmpty() &&
                username.length() >= UserSettings.MIN_USERNAME_LENGTH &&
                username.length() < UserSettings.MAX_USERNAME_LENGTH &&
                username.matches(UserSettings.USERNAME_PATTERN);
    }

    private static boolean isCommand(String input) {
        String trimmedInput = input.trim();
        String regex = !trimmedInput.contains(" ") ? "^\\/[a-z]+$" : "^\\/[a-z]+\\s+\\S+";
        return trimmedInput.matches(regex);
    }
}