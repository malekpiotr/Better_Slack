package network;

import java.io.IOException;

public interface ChatServer extends DisconnectObserver {
    void start(int port);
    void shutdown() throws IOException;
    boolean isOnline();
}
