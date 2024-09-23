package queque.aulas.estruturas;

import base.estruturaestatica.EstruturaEstatica;

public class Fila<T> extends EstruturaEstatica<T> {

    public Fila(){
        super();
    }

    public Fila(int capacidade){
        super(capacidade);
    }

    public void enfileirar(T elemento){
        super.adiciona(elemento);
    }

    public T desenfileirar(){
        if(!(estaVazia())){
            T aux = this.elementos[0];
            super.remove(0);
            return aux;
        }
        return null;
    }

    public T proximo(){
        if(!(estaVazia())) {
            return this.elementos[0];
        }
        return null;
    }

}
