/**
 * Created by conno on 11/04/2017.
 */
public class fourutwop {

    // Main program
    public static void main(String[] args) {

        // Added a try/catch so it doesn't die when nothing is passed!
        try {
            // Getting the option flag
            String optFlag = args[0];

            // Checking the flag
            switch (optFlag) {
                case "-s":
                    sendFile(args);
                    break;
                case "-r":
                    recFile(args);
                    break;
                default:
                    System.out.println("Invalid flag!");
                    break;
            }

        } catch (ArrayIndexOutOfBoundsException aoob) {
            // Throwing an error if no flags were passed
            System.out.println("You must provide a flag ");
        }

    }

    // Used to send a file
    public static void sendFile(String[] args) {

        try {
            // Getting the destination address, port and file
            String filePath = args[1];
            String destAddress = args[2];
            int destPort = Integer.parseInt(args[3]);

            // Checking that they both exist
            if (!destAddress.isEmpty() && !filePath.isEmpty()) {
                // Both are provided
                System.out.println(destAddress);
            } else {
                // They were not present
                System.out.println("You must provide both a destination address and port");
            }

        } catch (ArrayIndexOutOfBoundsException aoob) {
            // Throwing an error if no parameters were passed
            System.out.println("You must provide both a destination address and port");
        }

    }

    // Used to receive a file
    public static void recFile(String[] args) {

        // Adding a try/catch so it doesn't die
        try {
            // Getting the port
            int port = Integer.parseInt(args[1]);
            // Firing up a new server
            fourutwopServer newServer = new fourutwopServer(port);
            newServer.start();

        } catch (ArrayIndexOutOfBoundsException aoob) {
            // Throwing an error if no parameters were passed
            System.out.println("You must provide a port for the server to listen on!");
        }

    }

}
