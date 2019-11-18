package fachada;

import Cliente.*;
import entregador.*;
import mercadoria.*;
import vendas.*;
public class LojaMagica {
	private CadastroMercadorias mercadoria;
	private CadastroVendas vendas;
	private CadastroEntregador entregador;
	private CadastroCliente cliente;
	
	public LojaMagica (RepositorioMercadoria mercadoria,VendasInterface vendas,RepositorioEntregadores entregador,RepositorioCliente cliente) {
		this.mercadoria = new CadastroMercadorias(mercadoria);
		this.vendas = new CadastroVendas(vendas);
		this.entregador=new CadastroEntregador(entregador);
		this.cliente=new CadastroCliente(cliente);
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
	public void cadastrarEntregador(Entregador Entregadores) throws EntregadorJaCadastroException {
		if (!this.entregador.verificarEntregador(Entregadores.getCpf())) {
			this.entregador.inserirEntregador(Entregadores);
		} else {
			throw new EntregadorJaCadastroException();
		}
	}

	public void removerEntregador(String cpf) throws EntregadorNaoEncontradoException {
		this.entregador.removerEntregador(cpf);
	}

	public boolean verificarEntregador(String cpf) {
		return this.entregador.verificarEntregador(cpf);
	}

	public void atualizarTransporteEntregador(String cpf, String transporte) throws EntregadorNaoEncontradoException {
		this.entregador.atualizarTransporteEntregador(cpf, transporte);
	}

	public Entregador procurarEntregador(String cpf) throws EntregadorNaoEncontradoException {
		return this.entregador.procurarEntregador(cpf);
	}
	 public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException, LimiteClientesAtingidoException {
	        if (!this.cliente.existe(cliente.getCpf())) {
	            this.cliente.inserir(cliente);
	        } else {
	            ClienteJaCadastradoException e;
	            e = new ClienteJaCadastradoException();
	            throw e;
	        }
	    }

	 public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
	        this.cliente.atualizar(cliente);
	    }

	    public void remover(String cpf)
	            throws ClienteNaoEncontradoException {
	        this.cliente.remover(cpf);
	    }

	    public Cliente procurar(String cpf)
	            throws ClienteNaoEncontradoException {
	        return this.repositorio.procurar(cpf);
	    }


}	

