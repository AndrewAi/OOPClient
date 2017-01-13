/**
 * Created by AndrewIrwin on 10/01/2017.
 */


import java.io.*; //We need the Java IO library to read from the socket's input stream and write to its output stream
import java.net.*; //Sockets are packaged in the java.net library
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Scanner;

public class WebClient { //The class WebClient must be declared in a file called WebClient.java

    private static Boolean keepRunning = false;
    private static Scanner console = new Scanner(System.in);

    //Main method to get the ball rolling
    public static void connectToServer() throws Throwable{
        //final String request = "GET /characters.txt HTTP/1.1\n\n"; //The message to send to the server


       // keepRunning = true;

         //Scanner console;
        //if (option == 2){
          //     keepRunning = false;
       // }


        //console = new Scanner(System.in);

        //menu();

        //Loop 10 times to simulate 10 concurrent connections to the server. Examine the output and increase to 10000
       // for (int i = 0; i < 10; i++){

			/* Create a new Thread using the constructor Thread(Runnable r, String threadName).
			 * The Runnable is created on-the-fly as an anonymous inner class. Normally it should
			 * be declared either in its own class or as an inner class (for encapsulation).
			 */
            new Thread(new Runnable(){
                /* Every thread / runnable needs a run() method. Any objects instantiated inside run() and not passed
                 * as arguments to other objects are thread-safe, i.e. there is no need to worry about synchronization.
                 */
                public void run() {

                    //WebClient client = new WebClient();

                    try { //Attempt the following. If something goes wrong, the flow jumps down to catch()

                        Socket s = new Socket("localhost", 7777); //Connect to the server
                        System.out.println("Connected to Server");
                        String userInput = "2";

                        //do {
                            System.out.println("Please Enter 2, to list files. 3 to download, 4 to quit");
                           //  userInput = console.next();
                            System.out.println("UserInput: " + userInput);

                            //Serialise / marshal a request to the server
                            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                            out.writeObject(userInput); //Serialise
                            out.flush(); //Ensure all data sent by flushing buffers

                             //Thread.yield(); //Pause the current thread for a short time (not used much)

                        String threadName = Thread.currentThread().getName();
                            //Deserialise / unmarshal response from server
                        if (userInput.equalsIgnoreCase("2")) {

                            try {


                                ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                                //ArrayList<String> clientFileList = (ArrayList<String>) in.readObject(); //Deserialise
                                Object object = in.readObject();
                                ArrayList<String> clientFileList = (ArrayList<String>) object;

                                System.out.println("ClientFileList: " + clientFileList.toString());
                            }
                            catch (ClassNotFoundException e){
                                e.printStackTrace();
                                System.out.println("FAiled");
                            }

                        }

                        // else if (2) ... read in file
                        // else do standard below

                        else {

                            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                            String serverResponse = (String) in.readObject();

                            //Get the name of the thread (worker) doing this runnable (job)

                            System.out.println(serverResponse + "-->" + threadName + " going to sleep...");
                            // } while (!userInput.equalsIgnoreCase("4"));
                        }

                        //Pause this thread for 10 secs
                        ///Thread.sleep(10000);

                        System.out.println(threadName + " just woke up and closing socket...");

                        s.close(); //Tidy up

                    } catch (Exception e) { //Deal with the error here. A try/catch stops a programme crashing on error
                        System.out.println("Error: " + e.getMessage());
                    }//End of try /catch
                }//End of run(). The thread will now die...sob..sob...;)

            }, "Client-" + 1).start(); //Start the thread
     //   }//End of for loop

        System.out.println("Main method will return now....");



    }//End of main method




   // public static void  listAll







}//End of class