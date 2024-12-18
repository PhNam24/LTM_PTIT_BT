package RMI;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;

public class RMI_Byte {
    public static void main(String[] args) throws IOException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService service = (ByteService) registry.lookup("RMIByteService");

        byte[] bytes = service.requestData("B21DCCN554", "7tXljpqE");
        byte[] ans = new byte[bytes.length];
        int idx = 0;
        for (byte b : bytes) {
            if (b % 2 == 0) {
                ans[idx++] = b;
            }
        }
        for (byte b : bytes) {
            if (b % 2 != 0) {
                ans[idx++] = b;
            }
        }
        System.out.println(Arrays.toString(ans));
        service.submitData("B21DCCN554", "7tXljpqE", ans);
    }
}
