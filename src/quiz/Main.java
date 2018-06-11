package quiz;

import Score.Score;
import fichier.Fichiers;
import lecteurFichier.LecteurFichier;
import questions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int select;
        String reponseDonne;
        BanqueQuestion banqueQuestion = new BanqueQuestion();
        Fichiers fichiers = new Fichiers();

//        LecteurFichier lecteurFichier = new LecteurFichier();
//
//        ArrayList<String[]> r = lecteurFichier.lir("/Users/jcneto/IdeaProjects/TP1 POOII - L'héritage/src/fichier/QuestionResponce.txt");
//
//        for (int i = 0; i < r.size(); i++) {
//            String[] a = r.get(i);
//            System.out.println(a[0] + " * " + a[1]);
//        }

        System.out.println();
        System.out.println();
        System.out.println("Escreva seu nome :");
        String nom = sc.nextLine();
        Score scoreQuiz = new Score(nom);
        scoreQuiz.setDataDebut();
        System.out.println(scoreQuiz.getDataDebut());
        System.out.println("================= * =================");
        System.out.println("Slecione o tipo de questão de multipla escolha :");
        System.out.println("1 : Pais/Capital \n2 : Provincia/Capital \n3 : Fruta/Cor \n");
        System.out.println("Digite uma opção :");
        try {
            select = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            select = 0;
        }
        while (select == 0 || select > 4) {
            System.out.println("Mauvaise sélection");
            System.out.println("Digite uma opção :");
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
            System.out.println("Slecione o tipo de questão de multipla escolha :");
            System.out.println("1 : Brasil \n2 : Canada \n3 : USA \n");
            System.out.println("Digite o numero :");
            try {
                select = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                select = 0;
            }
            while (select == 0 || select > 4) {
                System.out.println("Mauvaise sélection");
                System.out.println("Digite uma opção :");
                try {
                    select = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    select = 0;
                }
            }
            System.out.printf(String.valueOf(select));
        }
        if (select == 3) {
            banqueQuestion.setNomFichier(fichiers.getFRUITS());
        }
        System.out.println("================= * =================");
        System.out.println("Quantas questoes voce gostaria de responder ?");
        System.out.println("digite um numero entre 10 à 20 :");
        try {
            banqueQuestion.setNbQuestions(Integer.parseInt(sc.nextLine()));
        } catch (NumberFormatException e) {
            banqueQuestion.setNbQuestions(0);
        }
        while (banqueQuestion.getNbQuestions() < 10 || banqueQuestion.getNbQuestions() > 30) {
            System.out.println("Mauvaise sélection");
            System.out.println("digite um numero entre 10 e 30");
            try {
                banqueQuestion.setNbQuestions(Integer.parseInt(sc.nextLine()));
            } catch (NumberFormatException e) {
                banqueQuestion.setNbQuestions(0);
            }
        }
        banqueQuestion.setQuestions();

        System.out.println("O quiz vai comesar em 1... 2... 3... Já !");

        while (banqueQuestion.getNbQuestions() >= 10){
            Questions question = banqueQuestion.prochaineQuestion();
            System.out.println(question.getQuestion());
            reponseDonne = sc.nextLine();
            if (question.validerReponse(reponseDonne)){
                System.out.println("Bravo!!! 👍");
                scoreQuiz.setReponceCorrect();
            } else {
                System.out.println("Mauvaise reponse 👎");
                scoreQuiz.setReponceIncorrect();
            }
        }


        scoreQuiz.setDataFin();


    }
}
