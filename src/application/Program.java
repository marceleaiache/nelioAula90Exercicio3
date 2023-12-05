package application;

import entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //DECLARAÇÃO VARIÁVEL DA QUANTIDADE DE PESSOAS QUE SERÁ INSERIDA PELO USUÁRIO
        int qntPerson;

        //IMPRESSÃO NA TELA PRO USUARIO INSERIR A QUANTIDADE DE PESSOAS A SEREM ISERIDAS
        System.out.println("Quantas pessoas serão digitadas?");
        qntPerson = sc.nextInt();

        //INSTANCIAÇÃO DO OBJETO PERSON
        Person[] vect = new Person[qntPerson];

        //IMPRESSÃO NA TELA PARA INSERIR DADOS DA PERSON
        for(int i=0; i<vect.length; i++) {
            System.out.printf("Dados da %da pessoa:%n", (i+1));
            sc.nextLine();
            System.out.println("Nome: ");
            String name = sc.nextLine();
            System.out.println("Idade: ");
            int age = sc.nextInt();
            System.out.println("Altura: ");
            double height = sc.nextFloat();

            //DECLARAÇÃO DO VETOR
            vect[i] = new Person(name, age, height);
        }

        //DECLARAÇÃO DA VARIÁVEL DA SOMA DAS ALTURAS
        double totalHeight = 0;

        for(int i=0; i<vect.length; i++){
            totalHeight += vect[i].getHeight();
        }

        //DECLARAÇÃO DA VARIÁVEL DA MÉDIA DAS ALTURAS
        double avg = totalHeight / vect.length;
        System.out.printf("Altura média: %.2f%n", avg);

        //DECLARAÇÃO DAS VARIÁVEIS DE QUANTIDADE DE PESSOAS C/ MENOS DE 16 ANOS E O PERCENTUAL
        int personUnder16;
        double percentUnder16;

        //ATRIBUIÇÃO DO VALOR DA VARIÁVEL PERCORRENDO O VETOR
        personUnder16 = 0;
        for (int i=0; i <vect.length; i++) {
            if (vect[i].getAge() < 16) {
                personUnder16++;
            }
        }

        //ATRIBUIÇÃO DO VALOR DA VARIAVEL
        percentUnder16 = (double) personUnder16 / vect.length * 100;

        //IMPRESSÃO NA TELA DA PORCENTAGEM DE PESSOAS COM MENOS DE 16 ANOS
        System.out.printf("Pessoas com menos de 16 anos: %.2f%%\n", percentUnder16);

        for(int i=0; i< vect.length; i++) {
            if (vect[i].getAge() <= 16) {
                System.out.println(vect[i].getName());
            }
        }

        sc.close();
    }
}
