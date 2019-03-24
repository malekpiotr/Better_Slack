import network.*;
import utils.BetterSlackInitializer;
import utils.DefaultInitializer;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        ChannelRepository channelRepository = new InMemoryChannelRepository();
        BetterSlackInitializer initializer = new DefaultInitializer(channelRepository);
        initializer.initialize();
        Collection<Channel> channel = channelRepository.getAll();
        ChatServer chatServer = new TcpChatServer(channelRepository);
        chatServer.start(50000);
    }
}