package linked_list.aulas.estruturas;

public class LinkedList<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;

    public int tamanho(){
        return this.tamanho;
    }

    public void adiciona(T elemento){
        No<T> celula = new No<>(elemento);
        if(this.tamanho==0){
            this.inicio = celula;
            this.ultimo = celula;
        } else if(this.tamanho > 0){
            ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }

    @Override
    public String toString(){
        if(this.tamanho == 0){
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        No<T> ponteiro = this.inicio;
        for(int i=0;i<this.tamanho-1;i++){
            builder.append(ponteiro.getElemento()).append(", ");
            ponteiro = ponteiro.getProximo();
        }

        builder.append(ponteiro.getElemento());

    /* builder.append(ponteiro.getElemento()).append(", ");
    while(ponteiro.getProximo() != null){
      ponteiro = ponteiro.getProximo();
      builder.append(ponteiro.getElemento()).append(", ");
    } */
        return builder.toString();
    }

    public void removeAll(){
        for(No<T> ponteiro = this.inicio;ponteiro!=null;){
            No<T> aux = ponteiro.getProximo();
            ponteiro.setElemento(null);
            ponteiro.setProximo(null);
            ponteiro = aux;
        }

        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public int busca(T elemento){
        No<T> ponteiro = this.inicio;
        for(int i=0;i<this.tamanho();i++){

        }
        return 0;
    }
}
