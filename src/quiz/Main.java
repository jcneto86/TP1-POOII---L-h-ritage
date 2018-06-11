package quiz;

import Score.Score;
import questions.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String fichierQuestionResponce = "/Users/jcneto/IdeaProjects/TP1 POOII - L'héritage/src/fichier/canada.txt";
        int select;
        String reponseDonne;
        BanqueQuestion banqueQuestion = new BanqueQuestion();

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
        System.out.println("================= * =================");
        System.out.println("Quantas questoes voce gostaria de responder ?");
        System.out.println("digite um numero entre 10 e 30");
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


//        System.out.println("O quiz vai comesar em 1... 2... 3... Já !");
//
//        while (numbreQuestionPourRepondrer >= 10){
//            System.out.println(bancQuestion.prochaineQuestion());
//            bancQuestion.prochaineQuestion();
//        }


//        scoreQuiz.setDataFin();


    }
}
