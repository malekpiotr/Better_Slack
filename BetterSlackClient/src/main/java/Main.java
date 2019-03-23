
public class Main {
    public static void main(String[] args) {
        NetworkBasedChatClient client = new TcpChatClient();
        client.connect("localhost", 50000);

        UserInputProvider inputProvider = new ConsoleInputProvider();
        while(client.isOnline()) {
            String userInput = inputProvider.getUserInput();
            client.sendMessage(userInput);
        }
        System.out.println("Bye bye!");
    }
}