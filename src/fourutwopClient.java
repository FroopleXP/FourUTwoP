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
    public void sendFile(Socket client, String fileDirectory) {

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

                while (bytesRead < fileSize) {
                    // Reading in byte at a time
                    int byteRead = fileBuff.read();
                    // Writing to the server
                    outBuff.write(byteRead);
                    // Increasing the amount read
                    bytesRead = byteRead;
                }

            } finally {
                // When all is done, close streams and connection to server
                fileBuff.close();
                outBuff.close();
                client.close();
            }

        } catch (IOException e) {
            // Catching errors
            System.out.println(e.toString());
        }

    }

}
