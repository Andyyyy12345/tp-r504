import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ClientTCP3 {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 2016);

        DataOutputStream dOut =
            new DataOutputStream(socket.getOutputStream());

        // Envoyer la chaîne au serveur
        dOut.writeUTF(args[0]);

        // Attendre la chaîne inversée
        DataInputStream dIn =
            new DataInputStream(socket.getInputStream());

        String rev = dIn.readUTF();

        // Afficher la réponse
        System.out.println("Réponse du serveur : " + rev);

        socket.close();
    }
}

