package entregador;


public class RepositorioEntregadoresArray implements RepositorioEntregadores {
	private Entregador[] entregadores;
	private int index;

	public RepositorioEntregadoresArray() {
		entregadores = new Entregador[0];
		index = 0;
	}

	public void inserirEntregador(Entregador entregador) throws EntregadorJaCadastroException {
		Entregador[] aux = new Entregador[index + 1];
		for (int i = 0; i <= index; i++) {
			if (i < index)
				aux[i] = entregadores[i];
			else if(i!=index&&entregadores[i]==entregador) {
				i=index+1;
				throw new EntregadorJaCadastroException();
			}
			else
				aux[i] = entregador;
		}
		index++;
		entregadores = aux;
	}

	public void removerEntregador(String cpf) throws EntregadorNaoEncontradoException {
		Entregador aux;
		boolean b = true;
		for (int i = 0; i < entregadores.length; i++) {
			if (entregadores[i].getCpf().equals(cpf)) {
				b = false;
				entregadores[i] = null;
				this.index--;
				while (i < entregadores.length - 1) {
					aux = entregadores[i];
					entregadores[i] = entregadores[i + 1];
					entregadores[i + 1] = aux;
					i++;
				}
			}
		}
		if (b) {
			throw new EntregadorNaoEncontradoException();
		}
	}

	public boolean verificarEntregador(String cpf) {
		for (int i = 0; i < entregadores.length; i++) {
			if (entregadores[i].getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}

	public Entregador procurarEntregador(String cpf) throws EntregadorNaoEncontradoException {
		boolean achou = false;
		for (int i = 0; i < this.index && !achou; i++) {
			if (entregadores[i] != null && entregadores[i].getCpf().equals(cpf)) {
				achou = true;
				return entregadores[i];
			}
		}
		if (!achou) {
			throw new EntregadorNaoEncontradoException();
		}
		return null;
	}

	public void atualizarEntregador(Entregador entregador) throws EntregadorNaoEncontradoException {
		for (int i = 0; i < index; i++) {
			if (entregadores[i].getCpf().equals(entregador.getCpf()))
				entregadores[i] = entregador;
			else if (i == index - 1)
				throw new EntregadorNaoEncontradoException();
		}
	}

}
