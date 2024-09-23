package avaliacao;

import queque.aulas.estruturas.Fila;

import java.util.ArrayList;
import java.util.Random;

public class Q1_InverterFila {
    public static void main(String[] args){
        Fila<Integer> fila = new Fila<>();
        geradorNumeros(fila);
        System.out.println(fila.toString());
        Fila<Integer> filaInvertida = inversorFila(fila);
        System.out.println(filaInvertida.toString());
    }

    private static void geradorNumeros(Fila<Integer> fila){
        Random random = new Random();
        int num;
        for (int i=0;i<=10;i++){
            num = random.nextInt(100);
            fila.enfileirar(num);
        }
    }

    private static Fila<Integer> inversorFila(Fila<Integer> fila){
        int tamanhoFila = fila.tamanho();
        ArrayList<Integer> auxiliar = new ArrayList<>(tamanhoFila);
        Fila<Integer> filaInvertida = new Fila<>(tamanhoFila);
        for(int c=0;c<=tamanhoFila-1;c++){
            int aux = fila.desenfileirar();
            auxiliar.add(aux);
        }

        for(int i=auxiliar.size()-1;i>=0;i--){
            int enfileirando = auxiliar.get(i);
            filaInvertida.enfileirar(enfileirando);
        }
        return filaInvertida;
    }
}
