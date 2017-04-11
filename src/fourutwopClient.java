import java.io.IOException;
import java.net.Socket;

/**
 * Created by conno on 11/04/2017.
 */
// When this is called, a new client is created to send a file to someone
public class fourutwopClient {

    // Server properties
    private int remotePort;
    private String remoteAddress;
    private Socket clientSocket;

    Socket fourutwopClient(String remoteAddress, int remotePort) {

        // Setting up the new client
        this.remoteAddress = remoteAddress;
        this.remotePort = remotePort;

        try {
            // Creating a new client, if no error is thrown, we're connected!
            this.clientSocket = new Socket(this.remoteAddress, this.remotePort);

        } catch (IOException e) {
            // Catching errors
            System.out.println(e.toString());
        }

        // Returning the object
        return this.clientSocket;

    }

    // Used to actually send the file
    public void sendFile(fourutwopClient client, String fileDirectory) {

        // Opening the file

    }

}
