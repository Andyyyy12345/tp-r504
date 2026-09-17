import java.net.Socket;
import java.io.DataOutputStream;

public class ClientTCP1 {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 2016);

        DataOutputStream dOut =
            new DataOutputStream(socket.getOutputStream());

        dOut.writeUTF("message test");

        socket.close();
    }
}

