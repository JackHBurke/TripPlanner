import java.util.*;
import java.util.Scanner;
/* Jack Burke
 *
 * Client
 *   This program uses the command line and user input to manage and utilize a travel system for cruises and flights
 *   Based on input, the user can create new information for the system, test booking for the system, or create a
 *   sample system.
 */

public class Client {

	public static void main(String[] args) {

        String type;
        SystemManager systemManager = new SystemManager();
        boolean stop = false;
        Scanner keyboard;

        while(!stop) {
            System.out.println();
            System.out.print("Press 'c' for client, 'a' for administrator, 't' for a sample system, 'e' to exit:    ");
            keyboard = new Scanner(System.in);
            System.out.println();
            type = keyboard.next();
            if (type.equals("a")) {
                systemManager.processAdmin();
            } else if (type.equals("c")) {
                systemManager.processClient();
            } else if (type.equals("t")) {
                systemManager.createSampleSystem();
            } else if (type.equals("e")) {
                stop = true;
            } else {
                System.out.println("Invalid choice, please choose again");
            }
        }
    }

}
