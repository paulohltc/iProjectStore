package entregador;

public class RepositorioEntregadoresArray implements RepositorioEntregadores {
	private Entregador[] entregadores;
	private int index;

	public RepositorioEntregadoresArray(int size) {
		entregadores = new Entregador[size];
		index = 0;
	}

	public void inserirEntregador(Entregador entregador) throws EntregadorJaCadastroException {
		if (entregadores[index] == entregador) {
			throw new EntregadorJaCadastroException();
		} else {
			entregadores[index] = entregador;
			index++;
		}
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

	public void atualizarTransporteEntregador(String cpf, String transporte) throws EntregadorNaoEncontradoException {
		boolean achou = false;
		for (int i = 0; i < this.index && !achou; i++) {
			if (entregadores[i] != null && entregadores[i].getCpf().equals(cpf)) {
				achou = true;
				this.procurarEntregador(cpf).setTransporte(transporte);

			}
		}
		if (!achou) {
			throw new EntregadorNaoEncontradoException();
		}
	}

}