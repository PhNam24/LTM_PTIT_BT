package WS;

import WS.vn.medianews.CharacterService;
import WS.vn.medianews.CharacterService_Service;

import java.util.ArrayList;
import java.util.List;

public class WS_CharacterService {
    public static void main(String[] args) {
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();

        List<String> input = port.requestStringArray("B21DCCN554", "cLIYDSDC");
        ArrayList<String> list = new ArrayList<>(input);
        System.out.println(list);

        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;

        for (String s : list) {
            minLen = Math.min(minLen, s.length());
            maxLen = Math.max(maxLen, s.length());
        }
        int idxMin = 0;
        int idxMax = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == minLen) {
                idxMin = i;
                minLen = Integer.MAX_VALUE;
            }
            if (list.get(i).length() == maxLen) {
                idxMax = i;
                maxLen = Integer.MIN_VALUE;
            }
        }
        String ans = list.get(idxMax) + ";" + list.get(idxMin);
        System.out.println(ans);
        port.submitCharacterString("B21DCCN554", "cLIYDSDC", ans);
    }
}