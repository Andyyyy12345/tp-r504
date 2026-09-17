import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServeurUDP {
    public static void main(String[] args) throws Exception {

        DatagramSocket sock = new DatagramSocket(1234);

        while (true) {
            System.out.println("-Waiting data");

            DatagramPacket packet =
                new DatagramPacket(new byte[1024], 1024);

            sock.receive(packet);

            String str = new String(
                packet.getData(), 0, packet.getLength()
            );

            System.out.println("str=" + str);

            // Renvoyer la chaîne au client
            byte[] data = str.getBytes();

            InetAddress addr = packet.getAddress();
            int port = packet.getPort();

            DatagramPacket response =
                new DatagramPacket(data, data.length, addr, port);

            sock.send(response);
        }
    }
}

