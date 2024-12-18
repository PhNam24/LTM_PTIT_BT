package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class UDP_String {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        DatagramSocket socket = new DatagramSocket();

        String code = ";B21DCCN554;i493RdG0";
        byte[] data = code.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        socket.send(packet);

        byte[] buffer = new byte[1024];
        DatagramPacket response = new DatagramPacket(buffer, buffer.length);
        socket.receive(response);
        String received = new String(response.getData(), 0, response.getLength());
        System.out.println(received);

        String[] input = received.split(";");
        String id = input[0];
        String str = input[1];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) > 0) {
                ans += String.valueOf(map.get(str.charAt(i))) + str.charAt(i);
                map.put(str.charAt(i), 0);
            }
        }
        String res = id + ";" + ans;
        System.out.println(res);
        byte[] data2 = res.getBytes();
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
        socket.send(packet2);

    }
}
