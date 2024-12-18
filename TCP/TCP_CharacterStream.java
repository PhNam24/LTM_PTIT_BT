package TCP;

import java.io.*;
import java.net.Socket;

public class TCP_CharacterStream {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String code = "B21DCCN554;XqbYMTHR";
        writer.write(code);
        writer.newLine();
        writer.flush();

        String input = reader.readLine();
        String res1 = "";
        String res2 = "";
        for(int i = 0; i < input.length(); i++) {
            if ((Character.toLowerCase(input.charAt(i)) >= 'a' && Character.toLowerCase(input.charAt(i)) <= 'z') || (Character.toLowerCase(input.charAt(i)) >= '0' && Character.toLowerCase(input.charAt(i)) <= '9')) {
                res1 += input.charAt(i);
            }
            else {
                res2 += input.charAt(i);
            }
        }
        System.out.println(res1 + "\n" + res2);
        writer.write(res1);
        writer.newLine();
        writer.write(res2);
        writer.newLine();
        writer.flush();
    }
}
