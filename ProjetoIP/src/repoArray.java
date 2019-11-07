
public class repoArray implements RepositorioFuncionarios {
	private Funcionarios funcionarios[] = new Funcionarios[10];
	private Funcionarios funcionario;

	public repoArray() {
		for (int i = 0; i < 10; i++) {
			funcionarios[i] = null;
		}
	}

	public boolean contratar(Funcionarios funcionario) {
		boolean check = false;
		for (int i = 0; i < 10 && check == false; i++) {
			if (this.funcionarios[i] == null) {
				this.funcionarios[i] = funcionario;
				check = true;
			}
		}
		return check;
	}

	public boolean demitir(Funcionarios funcionario) {
		boolean check = false;
		for (int i = 0; i < 10 && check == false; i++) {
			if (this.funcionarios[i] == null) {
				i = 10;
			} else if (this.funcionarios[i].getNome().equalsIgnoreCase(funcionario.getNome())) {
				check = true;
				if (i < 9) {
					this.funcionarios[i] = this.funcionarios[i + 1];
					this.funcionarios[i + 1] = null;
				} else
					this.funcionarios[i] = null;
			}
		}
		return check;
	}

	public int nFuncionarios() {
		int n = 0;
		for (int i = 0; i < 10; i++) {
			if (funcionarios[i] != null)
				n++;
		}
		return n;
	}
}
