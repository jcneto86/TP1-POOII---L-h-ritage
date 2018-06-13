package questions;

import lecteurFichier.LecteurFichier;

import java.util.ArrayList;
import java.util.Random;

public class BanqueQuestion {

    private int nbQuestions;
    private String nomFichier;
    private final String NOMFICHIERQF = "/Users/jcneto/IdeaProjects/TP1 POOII - L'héritage/src/fichier/QuestionResponce.txt";
    private ArrayList<Questions> questions = new ArrayList<>();

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public ArrayList<Questions> getQuestions() {
        return this.questions;
    }

    public void setNbQuestions(int nb) {
        this.nbQuestions = nb;
    }

    public int getNbQuestions() {
        return this.nbQuestions;
    }

    /** public void setQuestions()
     *
     * Remplissez le tableau questions des questions simples et le choix multiple de façon l'aléatoire entre les deux.
     *
     */
    public void setQuestions() {
        LecteurFichier lecteurFichier = new LecteurFichier();
        for (int i = nbQuestions; i >= 1; i--) {
            int n = (int) (Math.random() * 2);
            if (n == 0) {
                this.questions.add(creeQuestionReponse(lecteurFichier.lir(NOMFICHIERQF)));
            } else {
                this.questions.add(creeQuestionChoixMultiple(lecteurFichier.lir(nomFichier)));
            }
        }
    }

    /** public Questions creeQuestionReponse(ArrayList<String[]> reponsesArray)
     *
     * Construit une question et ses réponses.
     *
     * @param reponsesArray Un tableau avec une liste des questions et des réponses
     * @return Un objet Question
     */
    public Questions creeQuestionReponse(ArrayList<String[]> reponsesArray) {
        Questions q = new Questions();
        int n = nbRaoud(reponsesArray.size());
        String[] r = reponsesArray.get(n);
        q.setQuestion(r[0]);
        q.setReponse(r[1]);
        if (questionsEgale(q)) creeQuestionReponse(reponsesArray);
        return q;
    }

    /** public Questions creeQuestionChoixMultiple(ArrayList<String[]> reponsesArray)
     *
     * Construit une question à choix multiple et ses réponses mélangées.
     *
     * @param reponsesArray Un tableau avec une liste de question et des réponses
     * @return Un objet Question
     */
    public Questions creeQuestionChoixMultiple(ArrayList<String[]> reponsesArray) {
        ArrayList<String[]> ra = reponsesArray;
        Questions q = new Questions();
        String[] question = reponsesArray.get(0);
        ra.remove(0);
        int index = nbRaoud(ra.size());
        String[] reponse = ra.get(index);
        q.setReponsesArray(ra, index);
        q.setQuestion(question[0] + " " +
                reponse[0] + " ? " + "Options : [ " +
                q.getReponseArry(0) + ", " +
                q.getReponseArry(1) + ", " +
                q.getReponseArry(2) + ", " +
                q.getReponseArry(3) + " ]");
        q.setReponse(reponse[1]);
        if (questionsEgale(q)) creeQuestionChoixMultiple(reponsesArray);
        return q;
    }

    /** public Questions prochaineQuestion()
     *
     * Renvoie un objet Question aléatoire provenant de la table questions.
     *
     * @return Un objet Question
     */
    public Questions prochaineQuestion() {
        int i = nbRaoud(this.questions.size());
        Questions a = questions.get(i);
        questions.remove(i);
        return a;
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

    /** private boolean questionsEgale(Questions q)
     *
     * Vérifie si l'attribut question un objet Question existent dans la table questions.
     *
     * @param q Un objet Question
     * @return Vrai ou Frau
     */
    private boolean questionsEgale(Questions q) {
        Questions b = q;
        for (int i = 0; i < questions.size(); i++) {
            Questions a = questions.get(i);
            if (b.getQuestion().equals(a.getQuestion())) {
                return true;
            }
        }

        return false;
    }

}
