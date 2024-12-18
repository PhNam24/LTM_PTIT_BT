package UDP;

import java.io.IOException;
import java.net.*;

public class UDP_DataType {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        DatagramSocket socket = new DatagramSocket();

        String code = ";B21DCCN554;AyjraDg3";
        byte[] data = code.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        socket.send(packet);

        System.out.println(code);

        byte[] buffer = new byte[1024];
        DatagramPacket response = new DatagramPacket(buffer, buffer.length);
        socket.receive(response);
        String received = new String(response.getData(), 0, response.getLength());
        System.out.println(received);

        String[] input = received.split(";");
        String id = input[0];
        String str = input[1];
        int num = Integer.parseInt(input[2]);
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                ans.append((char) ((str.charAt(i) - 'a' + num) % 26 + 'a'));
            } else {
                ans.append((char) ((str.charAt(i) - 'A' + num) % 26 + 'A'));
            }
        }
        String res = id + ";" + String.valueOf(ans.toString());
        System.out.println(res);
        byte[] data2 = res.getBytes();
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
        socket.send(packet2);
    }
}
