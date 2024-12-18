package RMI;

import netscape.javascript.JSObject;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;

public class RMI_Character {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService characterService = (CharacterService) registry.lookup("RMICharacterService");

        String input = characterService.requestCharacter("B21DCCN554", "ECYlkHqX");
        System.out.println(input);
        String tmp = "";
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '"' && input.charAt(i) != '{' && input.charAt(i) != '}') {
                tmp += input.charAt(i);
            }
        }
        String[] data = tmp.split(",");
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();
        for(int i = 0; i < data.length; i++) {
            if (i % 2 == 0) {
                s1.add(data[i]);
            } else {
                s2.add(data[i]);
            }
        }
        String ans = "";
        for(int i = 0; i < s1.size(); i++) {
            if (i != s1.size() - 1) {
                ans += s1.get(i) + ",";
            }
            else {
                ans += s1.get(i) + ";";
            }
        }
        for(int i = 0; i < s2.size(); i++) {
            if (i != s2.size() - 1) {
                ans += s2.get(i) + ",";
            }
            else {
                ans += s2.get(i);
            }
        }
        System.out.println(ans);
        characterService.submitCharacter("B21DCCN554", "ECYlkHqX", ans);
    }
}
