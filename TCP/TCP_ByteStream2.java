package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class TCP_ByteStream2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        String code = "B21DCCN147;dVqSCx9P ";
        os.write(code.getBytes());
        os.flush();

        byte[] buffer = new byte[1024];
        int byteRead = is.read(buffer);
        String response = new String(buffer, 0, byteRead);
        String[] arr = response.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for(String str: arr) {
            list.add(Integer.parseInt(str));
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max1) {
                max2 = max1;
                max1 = list.get(i);
            } else if (list.get(i) > max2) {
                max2 = list.get(i);
            }
        }
        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == max2) {
                idx = i;
            }
        }
        String ans = max2 + "," + idx;
        System.out.println(ans);
        os.write(ans.getBytes());
        os.flush();
    }
}
