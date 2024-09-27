package linked_list.aulas.estruturas;

public class LinkedList<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;
    private final int NAO_ENCONTRADO = -1;


    //Metodos de adição

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


    public void adicionaInicio(T elemento){
        if(this.tamanho == 0){
            No<T> novoNo = new No<>(elemento);
            this.inicio = novoNo;
            this.ultimo = novoNo;
        } else {
            No<T> novoNo = new No<>(elemento, this.inicio);
            this.inicio = novoNo;
        }
    }
    public void adiciona(T elemento, int posicao){
        if(this.posicaoNaoExiste(posicao)){
            throw new IllegalArgumentException("Posicao inválida");
        } else if(posicao == 0){
            this.adicionaInicio(elemento);
        } else if(posicao == this.tamanho()){
            this.adiciona(elemento);
        } else{
            No<T> noAnterior = this.buscaPosicao(posicao);
            No<T> proximoNo = noAnterior.getProximo();
            No<T> novoNo = new No<>(elemento, proximoNo);
            noAnterior.setProximo(novoNo);
            this.tamanho++;
        }
    }

    //Metodos de remoção
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

    public T removeInicio(){
        if(this.tamanho() == 0){
            throw new RuntimeException("Lista Vazia");
        }
        T removido = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;
        if(this.tamanho() == 0){
            this.ultimo = null;
        }

        return removido;
    }

    public T removeFinal(){
        if(this.tamanho() == 0){
            throw new RuntimeException("Lista Vazia");
        }
        if(this.tamanho == 1){
            return this.removeInicio();
        }

        No<T> penultimo = this.buscaPosicao(this.tamanho-2);
        T removido = penultimo.getProximo().getElemento();
        penultimo.setProximo(null);
        tamanho--;
        return removido;
    }

    public T remove(int posicao){
        if(this.posicaoNaoExiste(posicao)){
            throw new IllegalArgumentException("Posicao não existe");
        }
        if(this.tamanho() == 0){
            throw new RuntimeException("Lista Vazia");
        }
        if(this.tamanho == 1){
            return this.removeInicio();
        } else if(posicao == this.tamanho-1){
            return this.removeFinal();
        } else{
            No<T> noAnterior = this.buscaPosicao(posicao-1);
            No<T> noAtual = noAnterior.getProximo();
            T removido = noAtual.getElemento();
            noAnterior.setProximo(noAtual.getProximo());
            this.tamanho--;
            return removido;
        }

    }

    //Métodos de busca

    private No<T> buscaPosicao(int posicao){
        if(this.posicaoNaoExiste(posicao)) {
            throw new IllegalArgumentException("Posicao inválida");
        }
        No<T> ponteiro = this.inicio;
        for(int i=0;i<posicao;i++){
            ponteiro = ponteiro.getProximo();
        }
        return ponteiro;
    }

    public T busca(int posicao){
        return this.buscaPosicao(posicao).getElemento();
    }

    public int buscaElemento(T elemento){
        No<T> ponteiro = this.inicio;
        for(int i=0;i<this.tamanho();i++){
            if(ponteiro.getElemento().equals(elemento)){
                return i;
            } else{
                ponteiro = ponteiro.getProximo();
            }
        }
        return NAO_ENCONTRADO;
    }

    //Métodos especiais

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

    public int tamanho(){
        return this.tamanho;
    }

    private boolean posicaoNaoExiste(int posicao){
        return !(posicao >= 0 && posicao <= this.tamanho);
    }


}
