package entregador;

public class CadastroEntregador {

	private RepositorioEntregadores repositorio;

	public CadastroEntregador(RepositorioEntregadores repo) {
		repositorio = repo;
	}

	public void cadastrarEntregador(Entregador entregador) throws EntregadorJaCadastroException {
		if (!this.repositorio.verificarEntregador(entregador.getCpf())) {
			this.repositorio.inserirEntregador(entregador);
		} else {
			throw new EntregadorJaCadastroException();
		}
	}

	public void removerEntregador(String cpf) throws EntregadorNaoEncontradoException {
		this.repositorio.removerEntregador(cpf);
	}

	public boolean verificarEntregador(String cpf) {
		return this.repositorio.verificarEntregador(cpf);
	}

	public void atualizarTransporteEntregador(String cpf, String transporte) throws EntregadorNaoEncontradoException {
		this.repositorio.atualizarTransporteEntregador(cpf, transporte);
	}

	public Entregador procurarEntregador(String cpf) throws EntregadorNaoEncontradoException {
		return this.repositorio.procurarEntregador(cpf);
	}

	public void inserirEntregador(Entregador entregadores) {
		this.inserirEntregador(entregadores);
		
	}

}	
