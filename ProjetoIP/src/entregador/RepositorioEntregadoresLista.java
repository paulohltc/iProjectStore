package entregador;

public class RepositorioEntregadoresLista implements RepositorioEntregadores {
	private Entregador entregador;
	private RepositorioEntregadoresLista next;

	public RepositorioEntregadoresLista() {
		this.entregador = null;
		this.next = null;
	}

	public RepositorioEntregadoresLista(Entregador entregador) {
		this.entregador = entregador;
		this.next = null;
	}

	public void inserirEntregador(Entregador entregador) throws EntregadorJaCadastroException {
		if (this.entregador.equals(entregador)) {
			throw new EntregadorJaCadastroException();
		}
		if (this.next == null) {
			if (this.entregador == null) {
				this.entregador = entregador;
			} else {
				this.next = new RepositorioEntregadoresLista(entregador);
			}
		} else {
			this.next.inserirEntregador(entregador);
		}
	}

	public void removerEntregador(String cpf) throws EntregadorNaoEncontradoException {
		if (this.entregador != null) {
			this.entregador = this.next.entregador;
			this.next = this.next.next;
		} else {
			throw new EntregadorNaoEncontradoException();
		}
	}

	public boolean verificarEntregador(String cpf) {
		while (this.entregador != null) {
			if (this.entregador.getCpf().equals(cpf)) {
				return true;
			}
			this.next.verificarEntregador(cpf);
		}
		return false;
	}

	public void atualizarTransporteEntregador(String cpf, String transporte) throws EntregadorNaoEncontradoException {
		while (this.entregador != null) {
			if (this.entregador.getCpf().equals(cpf)) {
				this.entregador.setTransporte(transporte);
			}
			this.next.atualizarTransporteEntregador(cpf, transporte);
		}
		throw new EntregadorNaoEncontradoException();
	}
	
	public Entregador procurarEntregador(String cpf) throws EntregadorNaoEncontradoException {
		while (this.entregador != null) {
			if (this.entregador.getCpf().equals(cpf)) {
				return this.entregador;
			}
			this.next.procurarEntregador(cpf);
		}
		throw new EntregadorNaoEncontradoException();			
	}
	

}
