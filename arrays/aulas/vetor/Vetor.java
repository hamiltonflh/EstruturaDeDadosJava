package arrays.aulas.vetor;

public class Vetor<T> {

	private T[] elementos;
	private int tamanho;

	public Vetor(int capacidade){
		this.elementos = (T[]) new Object[capacidade];
		this.tamanho = 0;
	}

	public Vetor(){
		this(10);
	}

	/*public void adiciona(String elemento){
		for (int i=0; i<this.elementos.length; i++){
			if (this.elementos[i] == null){
				this.elementos[i] = elemento;
				break;
			}
		}
	}*/

	/*public void adiciona(String elemento) throws Exception{

		if (this.tamanho < this.elementos.length){
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
		} else {
			throw new Exception("Vetor já está cheio, não é possível adicionar mais elementos");
		}

	}*/

	public boolean adiciona(T elemento) {
		this.aumentaCapacidade();
		if (this.tamanho < this.elementos.length){
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		} 
		return false;
	}
	
	// 0 1 2 3 4 5 6 = tamanho é 5
	// B C E F G + +
	//
	public boolean adiciona(int posicao, T elemento){
		
		if (!(posicao >= 0 && posicao < tamanho)){
			throw new IllegalArgumentException("Posição inválida");
		}
		
		this.aumentaCapacidade();
		
		//mover todos os elementos
		for (int i=this.tamanho-1; i>=posicao; i--){
			this.elementos[i+1] = this.elementos[i];
		}
		this.elementos[posicao] = elemento;
		this.tamanho++;
		
		return true;
	}
	
	private void aumentaCapacidade(){
		if (this.tamanho == this.elementos.length){
			T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
			for (int i=0; i<this.elementos.length; i++){
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
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
		for (int i=0; i<this.tamanho; i++){
			if (this.elementos[i].equals(elemento)){
				return i;
			}
		}
		return -1;
	}

	public boolean contem(T elemento){
		return busca(elemento) > -1;
	}

	
	// B D E F F -> posição a ser removida é 1 (G)
	// 0 1 2 3 4 -> tamanho é 5
	// vetor[1] = vetor[2]
	// vetor[2] = vetor[3]
	// vetor[3] = vetor[4]
	public void remove(int posicao){
		if (!(posicao >= 0 && posicao < tamanho)){
			throw new IllegalArgumentException("Posição inválida");
		}
		for (int i=posicao; i<this.tamanho-1; i++){
			this.elementos[i] = this.elementos[i+1];
		}
		this.tamanho--;
	}

	public void remove(T elemento){
		int indice = this.busca(elemento);
		if(indice > -1){
			this.remove(indice);
		}
	}

	public void removeAll(){
		for(int i=0;i<this.tamanho-1;i++){
			this.elementos[i] = null;
		}
		this.tamanho = 0;
	}
	public int ultimoIndice(T elemento){
		for(int i=this.tamanho-1;i>=0;i--){
			if(this.elementos[i].equals(elemento)){
				return i;
			}
		}
		return -1;
	}
	
	public int tamanho(){
		return this.tamanho;
	}

	@Override
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		s.append("[");
		
		for (int i=0; i<this.tamanho-1; i++){
			s.append(this.elementos[i]);
			s.append(", ");
		}
		
		if (this.tamanho>0){
			s.append(this.elementos[this.tamanho-1]);
		}
		
		s.append("]");
		
		return s.toString();
	}
	
}
