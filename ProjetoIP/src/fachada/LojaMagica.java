package fachada;

import mercadoria.CadastroMercadorias;
import mercadoria.Mercadoria;
import mercadoria.MercadoriaJaCadastradaException;
import mercadoria.MercadoriaNaoEncontradaException;

public class LojaMagica {
	private CadastroMercadorias mercadoria;
	
	public void cadastrarMercadoria (Mercadoria mercadoria) throws MercadoriaJaCadastradaException {
		if (this.mercadoria.existe(mercadoria.getId())) {
			MercadoriaJaCadastradaException e;
			e = new MercadoriaJaCadastradaException();
			throw e;
		} else {
			this.mercadoria.cadastrar(mercadoria);
		}
	}
	
	public void removerMercadoria (int id) throws MercadoriaNaoEncontradaException{
		this.mercadoria.remover(id);
	}
	
	public void existeMercadoria (int id) {
		this.mercadoria.existe(id);
	}
	
	public void atualizarMercadoria (int id, int preco) throws MercadoriaNaoEncontradaException {
		if (this.mercadoria.existe(id)) {
			this.mercadoria.atualizar(id, preco);
		} else {
			MercadoriaNaoEncontradaException e;
			e = new MercadoriaNaoEncontradaException();
			throw e;
		}
	}
	
	public Mercadoria procurarMercadoria (int id) throws MercadoriaNaoEncontradaException {
		return this.mercadoria.procurar(id);
	}
}
