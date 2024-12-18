package TCP;

import java.io.*;
import java.net.*;
public class TCP_DataStream2 {
    public static int UCLN(int a, int b){
        while(b!=0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String code = "B21DCCN604;wnq9FoTv";
        out.writeUTF(code);
        out.flush();

        int a = in.readInt();
        int b = in.readInt();

        int ucln = UCLN(a, b);
        int bcnn = a * b / ucln;
        int tong = a+b;
        int tich = a * b;

        out.writeInt(ucln);
        out.writeInt(bcnn);
        out.writeInt(tong);
        out.writeInt(tich);
        out.flush();

        socket.close();
    }
}