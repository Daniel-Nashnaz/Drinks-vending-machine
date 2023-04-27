import java.io.*;
import java.net.*;
public class Client {
    private static BufferedReader fromServer;
    private static PrintWriter toServer;
    private Socket socket;

    public Client() {

        try {
            socket = new Socket("localhost", 8000);
            fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            toServer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeToServer(String str) {
        toServer.println(str);
        toServer.flush();
    }
    public String readFromServer() {
        try {
            return fromServer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void close() {
        try {
            toServer.close();
            fromServer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}