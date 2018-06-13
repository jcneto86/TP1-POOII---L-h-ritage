package quiz;

import Score.Score;
import fichier.Fichiers;
import questions.BanqueQuestion;
import questions.Questions;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int select;
        String reponseDonne = null;
        BanqueQuestion banqueQuestion = new BanqueQuestion();
        Fichiers fichiers = new Fichiers();

        System.out.println();
        System.out.println();
        // L'interaction de l'utilisateur avec le menu
        System.out.println("Écrivez votre nom :");
        String nom = sc.nextLine();
        Score scoreQuiz = new Score(nom);
        scoreQuiz.setDataDebut();
        System.out.println("================= * =================");
        System.out.println("Sélectionnez le type de question à choix multiples :");
        System.out.println("1 : Pays /Capitale \n2 : Province/Capitale \n3 : Fruit/Couleur \n");
        System.out.println("Entrez une option :");
        try {
            select = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            select = 0;
        }
        while (select == 0 || select > 4) {
            System.out.println("Mauvaise sélection");
            System.out.println("Entrez une option :");
            try {
                select = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                select = 0;
            }
        }
        System.out.printf(String.valueOf(select));
        if (select == 1) {
            banqueQuestion.setNomFichier(fichiers.getPAYS());
        }
        if (select == 2) {
            System.out.println("Sélectionnez le type de question à choix multiples :");
            System.out.println("1 : Brasil \n2 : Canada \n3 : USA \n");
            System.out.println("Entrez le numéro :");
            try {
                select = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                select = 0;
            }
            while (select == 0 || select > 3) {
                System.out.println("Mauvaise sélection");
                System.out.println("Entrez une option :");
                try {
                    select = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    select = 0;
                }
            }
            System.out.printf(String.valueOf(select));
            if (select == 1) {
                banqueQuestion.setNomFichier(fichiers.getBRASIL());
            }
            if (select == 2) {
                banqueQuestion.setNomFichier(fichiers.getCANADA());
            }
            if (select == 3) {
                banqueQuestion.setNomFichier(fichiers.getUSA());
            }
        }
        if (select == 3) {
            banqueQuestion.setNomFichier(fichiers.getFRUITS());
        }
        System.out.println("================= * =================");
        System.out.println("Combien de questions aimeriez-vous répondre ?");
        System.out.println("entrez un nombre entre 10 à 25 :");
        try {
            banqueQuestion.setNbQuestions(Integer.parseInt(sc.nextLine()));
        } catch (NumberFormatException e) {
            banqueQuestion.setNbQuestions(0);
        }
        while (banqueQuestion.getNbQuestions() < 10 || banqueQuestion.getNbQuestions() > 25) {
            System.out.println("Mauvaise sélection");
            System.out.println("entrez un nombre entre 10 à 25 :");
            try {
                banqueQuestion.setNbQuestions(Integer.parseInt(sc.nextLine()));
            } catch (NumberFormatException e) {
                banqueQuestion.setNbQuestions(0);
            }
        }
        // Fin de l'interaction de l'utilisateur avec le menu
        banqueQuestion.setQuestions();
        System.out.println("Qu'est-ce qui va commencer sur 1 ... 2 ... 3 ... Allons-y !");
        System.out.println("Si vous voulez quitter, entrez simplement 'Quitter'");
        int timing = banqueQuestion.getNbQuestions() - 1;
        while (timing >= 0 || reponseDonne.equals("QUITTER")) {
            Questions question = banqueQuestion.prochaineQuestion();
            System.out.println(question.getQuestion());
            System.out.println("Entrez votre réponse : '");
            reponseDonne = sc.nextLine().toUpperCase();
            if (question.validerReponse(reponseDonne)) {
                System.out.println("Bonnes réponses, Bravo!!! 👍");
                scoreQuiz.setReponceCorrect();
            } else {
                System.out.println("Mauvaise reponse 👎 \nLa bonne réponse est : " + question.getReponse());
                scoreQuiz.setReponceIncorrect();
            }
            timing--;
        }
        if (reponseDonne.equals("QUITTER")) {
            System.out.println(scoreQuiz.getNom() + ", que dommage, vous avez quitté le quiz ! 😔");
            System.out.println("Regardez votre résultat partiel : " + "\nTotal des questions : " + banqueQuestion.getNbQuestions() + "\nBonnes réponses : " + scoreQuiz.getReponceCorrect() + "\nRéponses incorrectes : " + scoreQuiz.getReponceIncorrect());
        } else {
            System.out.println(scoreQuiz.getNom() + ", vous avez terminé le quiz ! 😁");
            System.out.println("Regardez votre résultat : " + "\nTotal des questions : " + banqueQuestion.getNbQuestions() + "\nBonnes réponses : " + scoreQuiz.getReponceCorrect() + "\nRéponses incorrectes : " + scoreQuiz.getReponceIncorrect());
        }
        scoreQuiz.setDataFin();
    }
}
