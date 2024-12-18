package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class RMI_Data {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService service = (DataService) registry.lookup("RMIDataService");

        int data = (int) service.requestData("B21DCCN554", "RorvDMZc");
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(data); i++) {
            if (data % i == 0 ) {
                while (data % i == 0) {
                    ans.add(i);
                    data /= i;
                }
            }
        }
        if (data > 1) {
            ans.add(data);
        }
        System.out.println(ans);
        service.submitData("B21DCCN554", "RorvDMZc", ans);
    }
}
