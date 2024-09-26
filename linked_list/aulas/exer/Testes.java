package linked_list.aulas.exer;

import linked_list.aulas.estruturas.LinkedList;

public class Testes {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(3);
        lista.adiciona(4);
        lista.adiciona(5);
        lista.adiciona(6);

        System.out.println(lista.toString());

    }
}
