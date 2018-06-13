package questions;

public class Questions extends QuestionsChoixMultiple {

    private String question;
    private String reponse;

    public Questions() {
    }

    public String getQuestion() {
        return question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }


    /** public boolean validerReponse(String reponseDonne)
     *
     * Valide si la réponse d'un objet Question est égale à la réponse d'un autre objet Question.
     *
     * @param reponseDonne Una String avec la réponse
     * @return Vrai ou Frau
     */
    public boolean validerReponse(String reponseDonne) {
        if (reponseDonne.equals(this.reponse.toUpperCase())) return true;
        else return false;
    }
}
