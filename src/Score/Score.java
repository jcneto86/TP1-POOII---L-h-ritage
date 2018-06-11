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

    public Score(String nom, Date dataDebut, Date dataFin, int reponceCorrect, int reponceIncorrect) {
        this.nom = nom;
        this.dataDebut = dataDebut;
        this.dataFin = dataFin;
        this.reponceCorrect = reponceCorrect;
        this.reponceIncorrect = reponceIncorrect;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDataDebut() {
        return dataDebut;
    }

    public void setDataDebut() {
        this.dataDebut = new Date();
    }

    public Date getDataFin() {
        return dataFin;
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

    @Override
    public String toString() {
        return "Score{" + "nom='" + nom +
                '\'' + ", dataDebut=" + dataDebut +
                ", dataFin=" + dataFin +
                ", reponceCorrect=" + reponceCorrect +
                ", getReponceIncorrect=" + reponceIncorrect + '}';
    }
}
