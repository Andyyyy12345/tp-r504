import java.net.Socket;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class Clienthttp {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket(args[0], 80);

            OutputStreamWriter osw =
                new OutputStreamWriter(socket.getOutputStream());

            InputStreamReader isw =
                new InputStreamReader(socket.getInputStream());

            BufferedWriter bufOut =
                new BufferedWriter(osw);

            BufferedReader bufIn =
                new BufferedReader(isw);

            // Ajout du header User-Agent et passage en HTTP/1.1 (recommandé pour les hôtes virtuels)
            String request = "GET / HTTP/1.1\r\n" +
                             "Host: " + args[0] + "\r\n" +
                             "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64)\r\n" +
                             "Connection: close\r\n\r\n";

            bufOut.write(request, 0, request.length());
            bufOut.flush();

            String line = bufIn.readLine();

            while (line != null) {
                System.out.println(line);
                line = bufIn.readLine();
            }

            bufIn.close();
            bufOut.close();
            socket.close();

        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
    }
}
