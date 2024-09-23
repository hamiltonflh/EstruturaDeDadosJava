package avaliacao;

import java.util.Scanner;
import java.util.Stack;

public class Q2_Palindromo {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Stack<Character> pilha = new Stack<>();

        System.out.print("Digite uma palavra e eu direi se ela é um Palíndromo ou não: ");
        String palavra = scan.nextLine();

        for(char c : palavra.toCharArray()){
            pilha.push(c);
        }
        boolean resp = verificadorPalindromo(pilha);
        if(resp){
            System.out.println("A palavra "+palavra+" é um palíndromo.");
        } else{
            System.out.println("A palavra "+palavra+" não é um palíndromo.");
        }
    }

    private static boolean verificadorPalindromo(Stack<Character> pilha){
        int tamanhoPilha = pilha.size()-1;
        Stack<Character> pilhaAuxiliar = cloneStack(pilha);
        Stack<Character> novaPilha = new Stack<>();
        for(int i=0;i<=tamanhoPilha;i++){
            char aux = pilha.pop();
            novaPilha.push(aux);
        }
        return pilhaAuxiliar.equals(novaPilha);
    }

    public static Stack<Character> cloneStack(Stack<Character> pilha){
        int pilhaTamanho = pilha.size();
        Stack<Character> clone = new Stack<>();
        for(int i=0;i<pilhaTamanho;i++){
            clone.push(pilha.get(i));
        }
        return clone;
    }
}
