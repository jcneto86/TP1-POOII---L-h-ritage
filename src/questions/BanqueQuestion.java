package questions;

import lecteurFichier.LecteurFichier;

import java.util.ArrayList;
import java.util.Random;

public class BanqueQuestion {

    private int nbQuestions;
    private String nomFichier;
    private final String NOMFICHIERQF = "/Users/jcneto/IdeaProjects/TP1 POOII - L'héritage/src/fichier/QuestionResponce.txt";
    private ArrayList<Questions> questions = new ArrayList<>();
    private ArrayList<Integer> questionDonne = new ArrayList<>();

    public String getNomFichier() {
        return nomFichier;
    }

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

    public ArrayList<Integer> getQuestionDonne() {
        return questionDonne;
    }

    public void setQuestionDonne(int questionDonne) {
        this.questionDonne.add(questionDonne);
    }

    public void setQuestions() {
        LecteurFichier lecteurFichier = new LecteurFichier();
        ArrayList<String[]> aQ = lecteurFichier.lir(nomFichier);
        for (int i = 1; i <= nbQuestions; i++) {
            int n = (int) (Math.random() * 2);
            if (n == 0) {
                this.questions.add(creeQuestionReponse(lecteurFichier.lir(NOMFICHIERQF)));
            } else {
                this.questions.add(creeQuestionChoixMultiple(aQ));
            }
        }
    }

    public Questions creeQuestionReponse(ArrayList<String[]> reponsesArray) {
        Questions q = new Questions();
        int n = (int) (Math.random() * reponsesArray.size() + 1);
        String[] r = reponsesArray.get(n);
        q.setQuestion(r[0]);
        q.setReponse(r[1]);
        if (questionsEgale(q)) creeQuestionReponse(reponsesArray);
        return q;
    }

    public Questions creeQuestionChoixMultiple(ArrayList<String[]> reponsesArray) {
        ArrayList<String[]> ra = reponsesArray;
        int index = nbRaoud();
        Questions q = new Questions();
        ra.remove(0);
        String[] question = reponsesArray.get(0);
        String[] reponse = reponsesArray.get(index);
        q.setReponsesArray(ra, index);
        q.setQuestion(question[0] + " " + reponse[1] + " ? " + "Options : [ " + q.getReponseArry(0) + ", " + q.getReponseArry(1) + ", " + q.getReponseArry(2) + ", " + q.getReponseArry(3) + " ]");
        q.setReponse(reponse[1]);
        if (questionsEgale(q)) creeQuestionChoixMultiple(reponsesArray);
        return q;
    }

    public Questions prochaineQuestion() {
        int a = nbRaoud();
        return questions.get(a);

    }

    public boolean validerReponse(String reponse) {


        return false;
    }

    private int nbRaoud() {
        Random r = new Random();
        int n = r.nextInt(nbQuestions + 1);
        return n;
    }

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
