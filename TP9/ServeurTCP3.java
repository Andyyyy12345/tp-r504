import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ServeurTCP3 {
    public static void main(String[] args) throws Exception {

        ServerSocket socketserver = new ServerSocket(2016);

        while (true) {
            System.out.println("serveur en attente");

            Socket socket = socketserver.accept();

            System.out.println("Connection d'un client");

            DataInputStream dIn =
                new DataInputStream(socket.getInputStream());

            String msg = dIn.readUTF();

            System.out.println("Message: " + msg);

            // Inverser la chaîne
            String rev = new StringBuilder(msg).reverse().toString();

            // Envoyer la chaîne inversée au client
            DataOutputStream dOut =
                new DataOutputStream(socket.getOutputStream());

            dOut.writeUTF(rev);

            socket.close();
        }
    }
}

