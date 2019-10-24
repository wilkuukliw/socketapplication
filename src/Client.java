import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Anna Maria
 * Main client class.
 * This class connects to the server &
 * includes methods for obtaining the user's commands and validates them.
 */

public class Client {

    public static void main(String[] args) {

        try {

            Socket cs = new Socket("127.0.0.1", 4200); //create a new Socket object, establishing connection to a program running on localhost
            InputStreamReader streamReader = new InputStreamReader(cs.getInputStream());  // connect readers & socket
            BufferedReader reader = new BufferedReader(streamReader);

            String msg = reader.readLine(); // client reads messages sent by server
            System.out.println("Hi Server: " + msg);

            reader.close(); // closing all streams

            } catch(UnknownHostException e){
                System.err.println("Unknown host");
            } catch(ConnectException e){
                System.err.println("Connection refused by host");
            } catch(IOException e){
                e.printStackTrace();

            }
        }
    }