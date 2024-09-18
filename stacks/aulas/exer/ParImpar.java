package stacks.aulas.exer;

import stacks.aulas.Pilha;

import java.util.Random;

public class ParImpar {
    public static void main(String[] args) throws InterruptedException {
        Pilha<Integer> par = new Pilha<>(10);
        Pilha<Integer> impar = new Pilha<>(10);
        Random random = new Random();
        int num;

        for(int i=0;i<=10;i++){
            num = random.nextInt(100);
            if(num==0){
                verificaZero(par,impar);
                continue;
            } else if(num%2==0){
                System.out.println("Número "+ num +" é par, empilhando na pilha par.");
                par.empilha(num);
            } else{
                System.out.println("Número "+ num +" é impar, empilhando na pilha impar.");
                impar.empilha(num);
            }
        }

        System.out.println("Desempilhando pilha par...");
        desempilha(par);
        System.out.println("Desempilhando pilha impar...");
        desempilha(impar);

    }

    public static void desempilha(Pilha<Integer> pilha) throws InterruptedException {
        if(pilha.estaVazia()){
            System.out.println("A pilha está vazia...");
        } else{
            for(int i=0;i<pilha.tamanho();i++){
                while(i< pilha.tamanho()-1){
                    System.out.print(pilha.desempilha()+" - ");
                    Thread.sleep(1000);
                }
                System.out.println(pilha.desempilha());
                Thread.sleep(1000);
            }
        }
    }

    public static void verificaZero(Pilha<Integer> par, Pilha<Integer> impar){
        if(!impar.estaVazia()){
            System.out.println("Número " + impar.desempilha() + " da pilha impar");
        } else{
            System.out.println("A pilha impar está vazia no momento...");
        }

        if(!par.estaVazia()) {
            System.out.println("Número " + par.desempilha() + " da pilha impar");
        } else {
            System.out.println("A pilha par está vazia no momento...");
        }
    }

}
