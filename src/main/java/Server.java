import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Server {
    private static Scanner scanner;
    private DataInputStream in;
    private DataOutputStream out;

    public void connect() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)){
            System.out.println("Сервер запущен");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String message = in.readUTF();
                            System.out.println(message);
                            if (message.equals("/end")) {
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
                            sendMessage("Server: " + text);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Server() {
        scanner = new Scanner(System.in);
        try {
            connect();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    public  void sendMessage(String text) {
        try {
            out.writeUTF(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Server();

    }
    }

