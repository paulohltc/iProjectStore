package fachada;

import mercadoria.*;
import vendas.*;
public class LojaMagica {
	private CadastroMercadorias mercadoria;
	private CadastroVendas vendas;
	
	public LojaMagica (RepositorioMercadoria mercadoria,VendasInterface vendas) {
		this.mercadoria = new CadastroMercadorias(mercadoria);
		this.vendas = new CadastroVendas(vendas);
	}
	
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
	public void VendaInserir (Sale sale) throws ExisteVendaException{
		this.vendas.VendaInserir(sale);
	}

	public void VendaRemover (String id) throws NaoExisteException {
		this.vendas.VendaRemover(id);
	}

	public boolean VendaExiste (String id) throws NaoExisteException{
		return this.vendas.VendaExiste(id);
	}

	public void VendaAtualizar (Sale sale) throws NaoExisteException {
		this.vendas.VendaAtualizar(sale);
	}

	public Sale VendaProcurar (String id) throws NaoExisteException {
		return this.vendas.VendaProcurar(id);
	}
}
