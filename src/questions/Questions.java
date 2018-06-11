package questions;

public class Questions extends QuestionsChoixMultiple {

    private String question;
    private String reponse;

    public Questions() {
    }

    public Questions(String question, String reponse) {
        this.question = question;
        this.reponse = reponse;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public boolean validerReponse(String essai) {
        if (essai.equals(this.reponse))
            return true;
        else
            return false;
    }
}
