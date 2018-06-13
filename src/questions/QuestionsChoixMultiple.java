package questions;

import java.util.ArrayList;
import java.util.Random;

public class QuestionsChoixMultiple {

    private String[] reponsesArray = new String[4];

    /** public String getReponseArry(int i)
     *
     * @param i index a retouner
     * @return un String qui et le resulta d'index i dans le tableau reponsesArray;
     */
    public String getReponseArry(int i) {
        return reponsesArray[i];
    }

    /** public void setReponsesArray(ArrayList<String[]> r, int index)
     *
     * Définit une table avec la bonne réponse et 3 incorrectes
     *
     * @param r Un ArrayList de tableau de String
     * @param index Une valeur entière
     */
    public void setReponsesArray(ArrayList<String[]> r, int index) {
        String[] reponse = r.get(index);
        this.reponsesArray[0] = reponse[1];
        for (int i = 1; i < 4; i++) {
            this.reponsesArray[i] = reponseOfIndex(r);
        }
        this.reponsesArray = shuffleArray(this.reponsesArray);
    }

    /** public String[] shuffleArray(String[] ar)
     *
     * Réorganiser la table au hasard.
     *
     * @param ar
     * @return
     */
    private String[] shuffleArray(String[] ar) {
        for (int i = ar.length - 1 ; i > 0; i--) {
            int index = nbRaoud(4);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }

    /** private int nbRaoud(int n)
     *
     * Une fonction qui renvoie une valeur aléatoire entre 0 et la valeur de n.
     *
     * @param n une valeur entière
     * @return une valeur entière
     */
    private int nbRaoud(int n) {
        Random r = new Random();
        int a = r.nextInt(n);
        return a;
    }

    /** private String reponseOfIndex(ArrayList<String[]> rQ)
     *
     * Renvoie une réponse aléatoire qui n'est pas égale à la bonne réponse.
     *
     * @param rQ Un ArrayList de tableau de String
     * @return Une String
     */
    private String reponseOfIndex(ArrayList<String[]> rQ) {
        int index = nbRaoud(rQ.size());
        String[] a = rQ.get(index);
        if (java.util.Arrays.asList(reponsesArray).contains(a[1]))
            reponseOfIndex(rQ);
        return a[1];
    }
}
