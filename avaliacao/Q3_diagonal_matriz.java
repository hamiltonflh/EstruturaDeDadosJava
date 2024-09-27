package avaliacao;

import arrays.aulas.vetor.estruturas.Vetor;

import java.util.Random;

public class Q3_diagonal_matriz {
    public static void main(String[] args) {
        int [][] matriz = new int[3][3];
        Vetor<Integer> diagonal_principal = new Vetor<>();
        preencherMatriz(matriz);


        System.out.println("Matriz: ");
        for(int l=0;l<matriz.length;l++){
            for(int c=0;c< matriz.length;c++){
                System.out.print("[" + matriz[l][c] + "]");
            }
            System.out.println(" ");
        }

        System.out.println(" ");

        System.out.println("Diagonal principal: ");

        diagonal_principal(matriz, diagonal_principal);
        System.out.println(diagonal_principal.toString());

    }

    private static void diagonal_principal(int[][] matriz, Vetor<Integer> vetor){
        for(int l=0;l<matriz.length;l++){
            for(int c=0;c< matriz.length;c++){
                if(c==l){
                   vetor.adiciona(matriz[l][c]);
                }
            }
        }
    }

    private static void preencherMatriz(int[][] matriz){
        Random random = new Random();
        for(int l=0;l<matriz.length;l++){
            for(int c=0;c<matriz.length;c++){
                int num = random.nextInt(100);
                matriz[l][c] = num;
            }
        }
    }

}
