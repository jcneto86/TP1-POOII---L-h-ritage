package questions;

import java.util.ArrayList;
import java.util.Random;
public class QuestionsChoixMultiple {

    private String[] reponsesArray = new String[4];

    public String getReponseArry(int i) {
        return reponsesArray[i];
    }

    public void setReponsesArray(ArrayList<String[]> r, int index) {
    }

    public String[] shuffleArray(String[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }
}
