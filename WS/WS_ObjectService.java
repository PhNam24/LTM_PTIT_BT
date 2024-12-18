package WS;

import WS.vn.medianews.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WS_ObjectService {
    public static void main(String[] args) {
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();

        ArrayList<StudentY> list = (ArrayList<StudentY>) port.requestListStudentY("B21DCCN554", "hKftbMz7");
        System.out.println(list);

        Set<String> subjects = new HashSet<>();
        for (StudentY studentY : list) {
            subjects.add(studentY.getSubject());
        }
        ArrayList<Float> bestScores = new ArrayList<>();
        for(String subject : subjects) {
            float maxScrore = 0;
            for (StudentY studentY : list) {
                if (studentY.getSubject().equals(subject)) {
                    maxScrore = Math.max(maxScrore, studentY.getScore());
                }
            }
            bestScores.add(maxScrore);
        }
        ArrayList<String> subjectsList = new ArrayList<>(subjects);
        System.out.println(subjects);
        System.out.println(bestScores);
        System.out.println(subjects.size() + ";" + bestScores.size());
        ArrayList<StudentY> ans = new ArrayList<>();
        for (StudentY studentY : list) {
            for (int i = 0; i < subjectsList.size(); i++) {
                if (studentY.getSubject().equals(subjectsList.get(i)) && studentY.getScore() == bestScores.get(i)) {
                    ans.add(studentY);
                    subjectsList.remove(i);
                    bestScores.remove(i);
                    break;
                }
            }
        }
        System.out.println(ans);

        port.submitListStudentY("B21DCCN554", "hKftbMz7", ans);
    }
}
