package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCP_ObjectStream {
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
        Socket socket;
        ObjectInputStream ois;
        ObjectOutputStream oos;
        socket = new Socket("203.162.10.109", 2209);
        ois = new ObjectInputStream(socket.getInputStream());
        oos = new ObjectOutputStream(socket.getOutputStream());

        String code = "B21DCCN554;xf3IomVD";
        oos.writeObject(code);

        Laptop laptop = (Laptop) ois.readObject();
        laptop.setName(reverse(laptop.getName()));
        int newQuan = Integer.parseInt(reverse(String.valueOf(laptop.getQuantity())));
        System.out.println(laptop.getName());
        System.out.println(newQuan);
        laptop.setQuantity(newQuan);

        oos.writeObject(laptop);
        socket.close();
    }
}
