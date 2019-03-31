import exceptions.EmptyMessageException;

public class Main {
    public static void main(String[] args) {
        NetworkBasedChatClient client = new TcpChatClient();
        client.connect("localhost", 50000);

        UserInputProvider inputProvider = new ConsoleInputProvider();
        while(client.isOnline()) {
            try {
                String userInput = inputProvider.getUserInput();
                client.sendMessage(userInput);
            } catch(EmptyMessageException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Bye bye!");
    }
}