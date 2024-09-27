package avaliacao;

import java.util.Random;

public class Q3_diagonal_matriz {
    public static void main(String[] args) {
        int [][] matriz = new int[3][3];
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

        diagonal_principal(matriz);

    }

    private static void diagonal_principal(int[][] matriz){
        for(int l=0;l<matriz.length;l++){
            for(int c=0;c< matriz.length;c++){
                if(c==l){
                    System.out.print("[" + matriz[l][c] + "]");
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
