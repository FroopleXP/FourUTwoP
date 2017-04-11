import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by conno on 11/04/2017.
 */
// When a new entity of this class is made, it's opened on a new Thread
public class fourutwopServer extends Thread {

    // Server properties
    private int port;
    private ServerSocket serverSocket;

    // Constructor
    fourutwopServer(int port) {
        // Trying to create a new server instance
        try {
            // Creating a new server instance
            this.serverSocket = new ServerSocket(port);
            this.port = serverSocket.getLocalPort();
        } catch (IOException e) {
            // Catching errors
            System.out.println("Failed to create a new server instance! Is something already running on port: " + port + "?");
            System.exit(-1);
        }

    }

    // When the thread is started, this is ran
    public void run() {
        // Waiting for something to connect
        while (true) {
            try {
                // Printing status message
                System.out.println("Server started on port: " + this.port);
                // This hangs the thread until someone connects, when they do the connectedClient is populated
                Socket connectedClient = serverSocket.accept();
                // We have a connection!
                System.out.println("New connected from: " + connectedClient.getRemoteSocketAddress());
            } catch (IOException e) {
                // Catching errors
                System.out.println(e.toString());
            }
        }
    }

}
