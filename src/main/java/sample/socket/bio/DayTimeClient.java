package sample.socket.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class DayTimeClient {
    public final static String HOST = "localhost";
    public final static int PORT = 13;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT)) {
            InputStream in = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");

            StringBuilder time = new StringBuilder();
            for (int c = reader.read(); c != -1; c = reader.read()) {
                time.append((char)c);
            }
            System.out.println(time.toString());
            System.out.println("Client closed");
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
