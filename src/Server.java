import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Anna Maria
 * Main server class.
 * This class listens & handles incoming connections.
 **/

public class Server {

    @SuppressWarnings("InfiniteLoopStatement")
    
    public static void main(String[] args) {

        String[] greetings = {"What's up?", "What's new?", "Hi man", "Hi brother", "How's your day going?", "How’s everything ?", "Good to see you", "I see you when I see you", "It’s been a while", "How do you do?", "Yo!", "Whazzup?", "G’day mate!", "Pleased to meet you"};

        try {

            ServerSocket ss = new ServerSocket(4200);  //create a new ServerSocket object to accept incoming request sent by client to the port 4200
            System.out.println(" Waiting for client to connect... \n");

            while (true) {

                Socket cs = ss.accept(); // new socket to talk to client.     accept (); stops execution of program until request is sent by client

                PrintWriter writer = new PrintWriter(cs.getOutputStream());
                String msg = chooseGreeting(greetings);
                writer.println(msg); // sending greeting to a client
                writer.close();
                System.out.println("Accepted connection. Server listening on localhost");
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        private static String chooseGreeting(String[] greetings) {

            int random = (int) (Math.random() * greetings.length);
            return greetings[random];
        }
    }


