package funcionario;
public class RepoositorioFuncionariosArray implements RepositorioFuncionarios {
	private Funcionarios funcionarios[] = new Funcionarios[10];

	public RepoositorioFuncionariosArray() {
		for (int i = 0; i < 10; i++) {
			funcionarios[i] = null;
		}
	}

	public void inserir(Funcionarios funcionario) {
		for (int i = 0; i < 10; i++) {
			if (this.funcionarios[i] == null) {
				this.funcionarios[i] = funcionario;

			}
		}

	}

	public void remover(Funcionarios funcionario) {
		for (int i = 0; i < 10; i++) {
			if (this.funcionarios[i] == null) {
				i = 10;
			} else if (this.funcionarios[i].getCpf().equals(funcionario.getCpf())) {
				if (i < 9) {
					this.funcionarios[i] = this.funcionarios[i + 1];
					this.funcionarios[i + 1] = null;
				} else
					this.funcionarios[i] = null;
			}
		}
	}

	public void atualizar(Funcionarios funcionario,String cpf) {
		Funcionarios removido=this.procurar(cpf);
		if(removido!=null) {
			removido=funcionario;
		} else {
			
		}
	}

	public Funcionarios procurar(String cpf) {
		for (int i = 0; i < 10; i++) {
			if (this.funcionarios[i].getCpf().equals(cpf) )
				return this.funcionarios[i];

		}
		return null;
	}

	public boolean existe(String cpf) {
		for (int i = 0; i < 10; i++) {
			if(this.funcionarios[i].getCpf().equals(cpf)) {
				return true;
			}
		}return false;
	}
}
