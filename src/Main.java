import java.io.IOException;
import java.util.Scanner;

/**
 * Created by AndrewIrwin on 11/01/2017.
 */
public class Main {

    static Scanner console = new Scanner(System.in);
    private static int choice;

    public static void main(String[] args) throws Throwable {

        System.out.println("Hello");


        // Parse Xml config file

        //console = new Scanner(System.in);
        do {
            menu();

        } while (choice != 4);

        System.out.println("Ending Connection");

       /* finally{
            //4: Closing connection
            try{
                in.close();
                out.close();
                requestSocket.close();
            }
            catch(IOException ioException){
                ioException.printStackTrace();
            }
        }
        */



    }




    public static void menu() {


        System.out.println("\n Welcome, Please Select an option");
        System.out.println("1. Connect to server ");
        System.out.println("2. Print File Listing ");
        System.out.println("3. Download File ");
        System.out.println("4. Quit ");
        System.out.println();
        System.out.println("Type Option [1-4] ");


        choice = console.nextInt();

        switch (choice){

            case 1:
                //connect to server
                System.out.println("Client Option 1 Selected");
                try {
                    WebClient.connectToServer();
                } catch (Throwable throwable) {
                    System.out.println("Cannot Connect to server");
                    throwable.printStackTrace();
                }
                //menu();

                break;

            case 2:
                // first check if client is connected to server
                // then list files

                // have code / method on server side to check files on the server!
                // selecting option will send message to server which will triger method in server
                // which will list server files and send them back to client

                System.out.println("Option 2 Selected");
               // WebClient.getAllFiles();
                menu();
                break;

            case 3:
                // also check if client is connected
                // if so prompt user to specify files
                // download specified files
                System.out.println("Option 3 Selected ");
                break;

            case 4:
                // Quit / close program
        }

    }


}
