package questions;

import java.util.ArrayList;
import java.util.Random;

public class QuestionsChoixMultiple {

    private String[] reponsesArray = new String[4];

    public String getReponseArry(int i) {
        return reponsesArray[i];
    }

    public void setReponsesArray(ArrayList<String[]> r, int index) {
        String[] response = r.get(index);
        this.reponsesArray[0] = response[1];
        for (int i = 1; i < 4; i++) {
            this.reponsesArray[i] = reponseOfIndex(r);
        }
        this.reponsesArray = shuffleArray(this.reponsesArray);
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
    private int nbRaoud(int n) {
        Random r = new Random();
        int a = r.nextInt(n + 1);
        return a;
    }
    private String reponseOfIndex(ArrayList<String[]> rQ) {
        int index = nbRaoud(rQ.size());
        String[] a = rQ.get(index);
        if (java.util.Arrays.asList(reponsesArray).contains(a[1]))
            reponseOfIndex(rQ);
        return a[1];
    }
}
