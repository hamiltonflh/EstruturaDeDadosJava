package queque.aulas.estruturas;

import base.estruturaestatica.EstruturaEstatica;

public class FilaPrioridade<T> extends Fila<T> {
    public FilaPrioridade(){super();}
    public FilaPrioridade(int capacidade){super(capacidade);}

    @Override
    public void enfileirar(T elemento){
        Comparable<T> chave = (Comparable<T>) elemento;
        int i;
        for(i=0;i<this.elementos.length;i++){
            if(chave.compareTo(this.elementos[i]) < 0) {
                break;
            }
        }
        super.adiciona(i,elemento);
    }
}
