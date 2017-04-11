/**
 * Created by conno on 11/04/2017.
 */
public class fourutwop {

    // Main program
    public static void main(String[] args) {

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

    }

    // Used to send a file
    public static void sendFile(String[] args) {

        // Getting the destination address and port
        String destAddress = args[1].toString();
        String destPort = args[2].toString();

        // Checking that they both exist
        if (!destAddress.isEmpty() && !destPort.isEmpty()) {
            // Both are provided
            System.out.println(destAddress);
        } else {
            // They were not present
            System.out.println("You must provide both a destination address and port");
        }

    }

    // Used to receive a file
    public static void recFile(String[] args) {

        // Getting the port
        String port = args[1].toString();

        // Checking the port was passed
        if (!port.isEmpty()) {
            System.out.println(port);
        } else {
            // Port was not passed
            System.out.println("You must provide a port for the server to listen on!");
        }

    }

}
