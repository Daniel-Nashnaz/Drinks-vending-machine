import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private static final Object chocolateLock = new Object();
    private static final Object coffeeLock = new Object();

    private static final Object teaLock = new Object();
    private static final Object whaterLock = new Object();
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        boolean keepAlive = true;
        while (keepAlive) {
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                String request = in.readLine();
                System.out.println("Received request: " + request);
                // Parse the request and start the appropriate drink preparation process
                switch (request) {
                    case "chocolate":
                        Thread t1 = new Thread(new Drinks.ChocolateProcess(out, chocolateLock));
                        t1.start();
                        break;
                    case "coffee":
                        Thread t2 = new Thread(new Drinks.CoffeeProcess(out,coffeeLock));
                        t2.start();
                        break;
                    case "tea":
                        Thread t3 = new Thread(new Drinks.TeaProcess(out,teaLock));
                        t3.start();
                        break;
                    case "water":
                        Thread t4 = new Thread(new Drinks.WaterProcess(out,whaterLock));
                        t4.start();
                        break;
                    case "exit":
                        keepAlive = false;
                        break;
                    default:
                        out.println("Invalid request.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}