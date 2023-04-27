import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Coffee machine server started.");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());
            // Create a new thread to handle the client's request
            Thread t = new Thread(new ClientHandler(clientSocket));
            t.start();
        }
    }
}
