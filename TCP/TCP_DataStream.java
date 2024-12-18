package TCP;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class TCP_DataStream {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String code = "B21DCCN554;b5IhEltI";
        out.writeUTF(code);
        out.flush();

        int n = in.readInt();
        int sum = 0;
        float avg = 0;
        float ps = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int tmp = in.readInt();
            sum += tmp;
            list.add(tmp);
        }
        avg = (float) sum / n;
        for(Integer i: list) {
            ps += (i - avg) * (i - avg);
        }
        ps = (ps / n);
        System.out.println(sum + "\n" + avg + "\n" + ps);
        out.writeInt(sum);
        out.writeFloat(avg);
        out.writeFloat(ps);
        out.flush();
    }
}
