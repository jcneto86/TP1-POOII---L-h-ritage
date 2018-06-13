package Score;

import java.util.Date;

public class Score {

    private String nom;
    private Date dataDebut;
    private Date dataFin;
    private int reponceCorrect;
    private int reponceIncorrect;

    public Score(String nom) {
        this.nom = nom;
        reponceCorrect = 0;
        reponceIncorrect = 0;
    }

    public String getNom() {
        return nom;
    }

    public void setDataDebut() {
        this.dataDebut = new Date();
    }

    public void setDataFin() {
        this.dataFin = new Date();
    }

    public int getReponceCorrect() {
        return reponceCorrect;
    }

    public void setReponceCorrect() {
        this.reponceCorrect = this.reponceCorrect+1;
    }

    public int getReponceIncorrect() {
        return reponceIncorrect;
    }

    public void setReponceIncorrect() {
        this.reponceIncorrect = this.reponceIncorrect+1;
    }

}
