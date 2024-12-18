package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMI_Object {
    public static String nameNormalization(String name) {
        String[] words = name.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService objectService = (ObjectService) registry.lookup("RMIObjectService");

        Student student = (Student) objectService.requestObject("B21DCCN554", "Ortlnxsb");
        System.out.println(student);

        student.setName(nameNormalization(student.getName()));
        String code = "B" + (student.getEnrollmentYear() % 100 < 10 ? "0" : "" + student.getEnrollmentYear() % 100);
        String[] nameSplit = student.getName().split(" ");
        code += nameSplit[nameSplit.length - 1].toUpperCase() + "_";
        for (int i = 0; i < nameSplit.length - 1; i++) {
            code += nameSplit[i].toUpperCase().charAt(0);
        }
        student.setCode(code);

        System.out.println(student);
        objectService.submitObject("B21DCCN554", "Ortlnxsb", student);
    }
}
