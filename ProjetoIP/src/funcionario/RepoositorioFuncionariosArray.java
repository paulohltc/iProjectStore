
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
			} else if (this.funcionarios[i].getNome().equalsIgnoreCase(funcionario.getNome())) {
				if (i < 9) {
					this.funcionarios[i] = this.funcionarios[i + 1];
					this.funcionarios[i + 1] = null;
				} else
					this.funcionarios[i] = null;
			}
		}
	}

	public void atualizar(int cpf, int idade) {
		for (int i = 0; i < 10; i++) {
			if (this.funcionarios[i].getCpf() == cpf) {
				this.funcionarios[i].setIdade(idade);
			}
		}
	}

	public Funcionarios procurar(int cpf) {
		for (int i = 0; i < 10; i++) {
			if (this.funcionarios[i].getCpf() == cpf)
				return this.funcionarios[i];

		}
		return null;
	}

	public boolean existe(int cpf) {
		for (int i = 0; i < 10; i++) {
			if(this.funcionarios[i].getCpf()==cpf) {
				return true;
			}
		}return false;
	}
}
