package arrays.aulas.vetor;

import base.estruturaestatica.EstruturaEstatica;

public class Lista<T> extends EstruturaEstatica<T> {

    public Lista(){
        super();
    }

    public Lista(int capacidade){
        super(capacidade);
    }



    public void adiciona(T elemento) {
        super.adiciona(elemento);
    }

    public void adiciona(int posicao, T elemento){
        super.adiciona(posicao, elemento);
    }

    public void remove(int posicao){
        super.remove(posicao);
    }

    public void remove(T elemento){
        int indice = this.busca(elemento);
        if(indice > -1){
            this.remove(indice);
        }
    }

    public T obtem(int posicao){
        if (!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posição inválida");
        }
        if(!(this.elementos[posicao] == null)){
            return this.elementos[posicao];
        }
        return null;
    }

    public int busca(T elemento){
        for (int i=0; i<this.tamanho(); i++){
            if (this.elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    public boolean contem(T elemento){
        return busca(elemento) > -1;
    }
}
