package ArraysAulas.vetor.exercicios;
import ArraysAulas.vetor.Vetor;

public class Exercicios {
    public static void main(String[] args){
        Vetor<String> vetor = new Vetor();

        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");
        vetor.adiciona("A");
        vetor.adiciona("E");
        vetor.adiciona("F");
        vetor.adiciona("A");

        //Exercicio 1 metodo contem
        System.out.println(vetor.contem("R"));
        System.out.println(vetor.contem("D"));

        //Exercicio 2 metodo ultimoIndice
        System.out.println(vetor.ultimoIndice("A"));
    }

}
