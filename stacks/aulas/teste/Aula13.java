package stacks.aulas.teste;
import stacks.aulas.*;

public class Aula13 {
    public static void main(String[] args){
        Pilha<Integer> pilha = new Pilha<>();

        for(int i=1;i<20;i++){
            pilha.empilha(i);
        }

        System.out.println(pilha.toString());
        System.out.println(pilha.topo());

        System.out.println(pilha.desempilha());
        System.out.println(pilha.topo());
    }


}
