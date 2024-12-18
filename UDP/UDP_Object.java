package UDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_Object {
    public static String reverse(String str) {
        String[] arr = str.split(" ");
        StringBuilder result = new StringBuilder();
        if (arr.length == 1) {
            for (int i = arr[0].length() - 1; i >= 0; i--) {
                result.append(arr[0].charAt(i));
            }
        } else {
            result.append(arr[arr.length - 1]).append(" ");
            for (int i = 1; i < arr.length - 1; i++) {
                result.append(arr[i]).append(" ");
            }
            result.append(arr[0]);
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InetAddress address = InetAddress.getByName("203.162.10.109");
        int poet = 2209;
        DatagramSocket socket = new DatagramSocket();

        String code = ";B21DCCN554;xF9ojMsm";
        byte[] data = code.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, address, poet);
        socket.send(packet);

        byte[] buffer = new byte[1024];
        DatagramPacket response = new DatagramPacket(buffer, buffer.length);
        socket.receive(response);
        String id = new String(response.getData(), 0, 8);

        ByteArrayInputStream bais = new ByteArrayInputStream(response.getData(), 8, response.getLength());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product product = (Product) ois.readObject();

        product.setName(reverse(product.getName()));
        int newQuan = Integer.parseInt(reverse(String.valueOf(product.getQuantity())));
        System.out.println(product.getName());
        System.out.println(newQuan);
        product.setQuantity(newQuan);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        oos.flush();

        byte[] data2 = new byte[8 + baos.size()];
        System.arraycopy(id.getBytes(), 0, data2, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, data2, 8, baos.size());
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, poet);
        socket.send(packet2);
    }
}
