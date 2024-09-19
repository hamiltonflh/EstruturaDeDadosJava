package stacks.aulas.exer;

import stacks.aulas.estruturas.Pilha;

import java.util.Scanner;

public class DecToBin {
    public static void main(String[] args){
        Pilha<Integer> binario = new Pilha<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o número que voce quer converter: ");
        int decimal = scan.nextInt();
        int print = decimal;


        conversor(decimal,binario);
        int tamanhoEstatico = binario.tamanho();

        System.out.print("O número "+ print + " convertido para binário é igual a: ");
        for (int i=0;i<tamanhoEstatico;i++) System.out.print(binario.desempilha());
        System.out.println(" ");
    }

    private static void conversor(int decimal, Pilha<Integer> binario){
        int empilhando;
        while(!(decimal < 1)){
            empilhando = decimal%2;
            binario.empilha(empilhando);
            decimal /= 2;
        }
    }
}
