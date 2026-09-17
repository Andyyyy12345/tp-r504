import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP {
    public static void main(String[] args) throws Exception {

        String s = "Hello World";
        byte[] data = s.getBytes();

        InetAddress addr = InetAddress.getLocalHost();

        DatagramPacket packet =
            new DatagramPacket(data, data.length, addr, 1234);

        DatagramSocket sock = new DatagramSocket();

        // Envoyer la chaîne au serveur
        sock.send(packet);

        // Attendre la réponse du serveur
        DatagramPacket response =
            new DatagramPacket(new byte[1024], 1024);

        sock.receive(response);

        String str = new String(
            response.getData(), 0, response.getLength()
        );

        System.out.println("Réponse du serveur : " + str);

        sock.close();
    }
}

