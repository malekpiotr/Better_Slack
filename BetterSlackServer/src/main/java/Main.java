import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        ServerExample serverExample = new ServerExample();
        serverExample.startServer(55555);
        Thread.sleep(5000);
        serverExample.shutdown();
    }
}