import java.io.*;
import java.net.Socket;
import java.nio.Buffer;

/**
 * Created by conno on 11/04/2017.
 */
// When this is called, a new client is created to send a file to someone
public class fourutwopClient {

    // Server properties
    private int remotePort;
    private String remoteAddress;
    private Socket clientSocket;

    fourutwopClient(String remoteAddress, int remotePort) {

        // Setting up the new client
        this.remoteAddress = remoteAddress;
        this.remotePort = remotePort;

        try {
            // Creating a new client, if no error is thrown, we're connected!
            this.clientSocket = new Socket(this.remoteAddress, this.remotePort);
            System.out.println("Connected to server!");

        } catch (IOException e) {
            // Catching errors
            System.out.println(e.toString());
        }

    }

    // Used to actually send the file
    public void sendFile(String fileDirectory) {

        Socket client = this.clientSocket;

        try {
            // Opening the file
            File fileToSend = new File(fileDirectory);
            // Creating a new file input stream
            FileInputStream fromFile = new FileInputStream(fileToSend);
            // Creating a buffered input stream for the file
            BufferedInputStream fileBuff = new BufferedInputStream(fromFile);
            // Creating a buffered output stream to the Server
            BufferedOutputStream outBuff = new BufferedOutputStream(client.getOutputStream());

            try {
                // Writing to the stream
                int fileSize = (int)fileToSend.length();
                int bytesRead = 0;

                // Sending the file
                System.out.println("Sending the file...");

                while (bytesRead < fileSize) {
                    // Reading in byte at a time
                    int byteRead = fileBuff.read();
                    // Writing to the server
                    outBuff.write(byteRead);
                    // Increasing the amount read
                    bytesRead++;
                }

            } finally {
                // When all is done, close streams and connection to server
                fileBuff.close();
                outBuff.close();
                System.out.println("File sent.");

                // Closing connection to remote server
                client.close();
                System.out.println("Closed connection to remote server.");

            }

        } catch (IOException e) {
            // Catching errors
            System.out.println(e.toString());
        }

    }

}
