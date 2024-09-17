package stacks.aulas.exer;


import stacks.aulas.Pilha;

import java.util.Random;

public class EmpilhaDesempilha {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Pilha<Integer> numeros = new Pilha<>(20);
        for(int i=0;i<=20;i++){
            int num = random.nextInt(100);
            if(num%2==0){
                numeros.empilha(num);
                System.out.println("Empilhando o número "+ num);
            } else if (num%2==1) {
                if(!numeros.estaVazia()){
                    System.out.println("Número " + num + " é ímpar, pior isso estou desempilhando o número " + numeros.desempilha()+ " da pilha.");
                } else{
                    System.out.println("Pilha está vazia");
                }
            }
        }

        if(!numeros.estaVazia()){
            System.out.println("Desempilhando os números que sobraram...");
            for(int i=0;i<numeros.tamanho();i++){
                Thread.sleep(1000);
                System.out.println(numeros.desempilha());
            }
        } else{
            System.out.println("A pilha terminou vazia");
        }

    }
}
