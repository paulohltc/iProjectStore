package fachada;

import Cliente.*;
import entregador.*;
import mercadoria.*;
import vendas.*;
import funcionario.*;
public class LojaMagica {
	private CadastroMercadorias mercadoria;
	private CadastroVendas vendas;
	private CadastroEntregador entregador;
	private CadastroCliente cliente;
	private CadastroFuncionarios funcionario;
	
	public LojaMagica (RepositorioMercadoria mercadoria,VendasInterface vendas,RepositorioEntregadores entregador,RepositorioCliente cliente,RepositorioFuncionarios funcionario) {
		this.mercadoria = new CadastroMercadorias(mercadoria);
		this.vendas = new CadastroVendas(vendas);
		this.entregador=new CadastroEntregador(entregador);
		this.cliente=new CadastroCliente(cliente);
		this.funcionario=new CadastroFuncionarios(funcionario);
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
	
	public void atualizarMercadoria (Mercadoria mercadoria) throws MercadoriaNaoEncontradaException {
		if (this.mercadoria.existe(mercadoria.getId())) {
			this.mercadoria.atualizar(mercadoria);
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

	public void atualizarEntregador(Entregador entregador) throws EntregadorNaoEncontradoException {
		this.entregador.atualizarEntregador(entregador);
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
	        return this.cliente.procurar(cpf);
	    }
	    public void cadastrarFuncionarios(Funcionarios funcionario) throws FuncionarioJaCadastradoException  {
	    	if(!this.funcionario.existe(funcionario.getCpf()))
	    		this.funcionario.inserir(funcionario);
	    	else 
	    		throw new FuncionarioJaCadastradoException();
	    }
	    public void  removerFuncionarios(Funcionarios funcionario) throws FuncionarioInexistenteException{
	    	if(this.funcionario.existe(funcionario.getCpf())==false)
	    		this.funcionario.remover(funcionario);
	    	else 
	    		throw new FuncionarioInexistenteException();
	    }
	    public void atualizarFuncioanrios(Funcionarios funcionario,String cpf) throws FuncionarioInexistenteException{
	    	if(this.funcionario.existe(funcionario.getCpf())==false)
	    		this.funcionario.atualizar(funcionario,cpf);
	    	else 
	    		throw new FuncionarioInexistenteException();
	    }
	    public Funcionarios procurarFuncionario(String cpf)throws FuncionarioInexistenteException {
	    	if(this.funcionario.existe(cpf)==true) 
	    		throw new FuncionarioInexistenteException();
	    	
	    	return this.funcionario.procurar(cpf);
	    	
	    		
	    }


}	

