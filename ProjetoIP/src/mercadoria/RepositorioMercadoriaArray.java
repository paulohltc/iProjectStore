package mercadoria;

public class RepositorioMercadoriaArray implements RepositorioMercadoria {
	private Mercadoria[] arrayMercadorias;
	private int index;
	
	public RepositorioMercadoriaArray () {
		this.arrayMercadorias = new Mercadoria[50];
		this.index = 0;
	}

	public void inserir(Mercadoria mercadoria){
		if (this.index < this.arrayMercadorias.length) { 
			this.arrayMercadorias[index] = mercadoria;
			index +=1;
		} 
	}

	public void remover(int id) throws MercadoriaNaoEncontradaException {
		int i = this.getIndex(id);
		if (this.arrayMercadorias.length - 1 - i >= 0) {
			System.arraycopy(arrayMercadorias, i + 1, this.arrayMercadorias, i, this.arrayMercadorias.length - 1 - i);
		}
		this.arrayMercadorias[this.arrayMercadorias.length - 1] = null;
		this.index -= 1;
	}

	public void atualizar(int id, int preco) throws MercadoriaNaoEncontradaException {
		int i = this.getIndex(id);
		arrayMercadorias[i].setPreco(preco);
	}
	
	public Mercadoria procurar(int id) throws MercadoriaNaoEncontradaException {
		Mercadoria encontrada = null;
		boolean achou = false;
		for (int i = 0; i <this.index && !achou; i++) {
			if (this.arrayMercadorias[i].getId() == id) {
				encontrada = this.arrayMercadorias[i];
				achou = true;
			}
		}
		if (achou) {
			return encontrada;
		} else {
			MercadoriaNaoEncontradaException e;
			e = new MercadoriaNaoEncontradaException();
			throw e;
		}

	}

	public boolean existe(int id) {
		boolean achou = false;
		for (int i = 0; i < this.index && !achou; i++) {
			if (this.arrayMercadorias[i].getId() == id) {
				achou = true;
			} else {
				achou = false;
			}
		}
		return achou;
	}
	
	public Mercadoria[] getArrayMercadorias() {
		return arrayMercadorias;
	}

	public void setArrayMercadorias(Mercadoria[] arrayMercadorias) {
		this.arrayMercadorias = arrayMercadorias;
	}

	public int getIndex(int id) {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
