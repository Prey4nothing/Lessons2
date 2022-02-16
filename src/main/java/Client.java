import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    private final static String SERVER_ADDRESS = "localhost";
    private final static int SERVER_PORT = 8080;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;


    public Client() {
        scanner = new Scanner(System.in);
        try {
            openConnection();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String messageFromServer = in.readUTF();
                        System.out.println(messageFromServer);
                        if(messageFromServer.equals("/end")) {
                            break;
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String text = scanner.nextLine();
                        if(text.equals("/end")) {
                            sendMessage(text);
                            closeConnection();
                        } else {
                            sendMessage("Client: " + text);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void closeConnection() {
        try {
            out.writeUTF("/end");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String text) {
        try {
            out.writeUTF(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}

