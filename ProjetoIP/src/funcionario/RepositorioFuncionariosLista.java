
public class RepositorioFuncionariosLista implements RepositorioFuncionarios {
	private Funcionarios funcionario;
	private RepositorioFuncionariosLista proximo;

	public RepositorioFuncionariosLista() {
		this.funcionario = null;
		this.proximo = null;
	}

	public void inserir(Funcionarios funcionario) {
		if (this.funcionario == null) {
			this.funcionario = funcionario;
			this.proximo = new RepositorioFuncionariosLista();
		} else
			this.proximo.inserir(funcionario);

	}

	public void remover(Funcionarios funcionario) {
		if (this.funcionario != null) {
			if (this.funcionario.getNome().equals(funcionario.getNome())) {
				this.funcionario = this.proximo.funcionario;
				this.proximo = this.proximo.proximo;
			} else
				this.proximo.remover(funcionario);
		}
	}

	public Funcionarios procurar(int cpf) {
		if (this.funcionario != null) {
			if (this.funcionario.getCpf() == cpf)
				return this.funcionario;
			else
				return this.proximo.procurar(cpf);
		} else
			return null;
	}

	public void atualizar(int cpf, int idade) {
		if (this.funcionario != null) {
			if (this.funcionario.getCpf() == cpf) {
				this.funcionario.setIdade(idade);
				
			} else
				 this.proximo.atualizar(cpf, idade);

		} 
			
	}
	
	public boolean existe(int cpf) {
		if(this.funcionario!=null) {
			if(this.funcionario.getCpf()==cpf)
				return true;
			else
				return this.proximo.existe(cpf);
		} return false;
	}
}
