import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) throws IOException {


        ServerExample serverExample = new ServerExample();
        serverExample.startServer(50000);
    }

}
