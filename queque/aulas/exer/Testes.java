package queque.aulas.exer;

import queque.aulas.estruturas.Fila;

public class Testes {
    public static void main(String[] args){
        Fila<String> fila = new Fila<String>();

        fila.enfileirar("Hamilton");
        fila.enfileirar("Camila");
        fila.enfileirar("Douglas");
        fila.enfileirar("Bia");
        fila.enfileirar("Cecilia");
        fila.enfileirar("Miguel");
        fila.enfileirar("Ana Liz");
        fila.enfileirar("Edileuza");
        System.out.println(fila.tamanho());
        System.out.println(fila.proximo());
        System.out.println(fila.desenfileirar());
        System.out.println(fila.proximo());
        System.out.println(fila.desenfileirar());
        System.out.println(fila.proximo());
        System.out.println(fila.desenfileirar());
        System.out.println(fila.proximo());
        System.out.println(fila.desenfileirar());
        System.out.println(fila.proximo());
        System.out.println(fila.desenfileirar());
        System.out.println(fila.proximo());
        System.out.println(fila.desenfileirar());
        System.out.println(fila.proximo());
        System.out.println(fila.tamanho());
    }
}
