
public interface RepositorioFuncionarios {
	public void inserir(Funcionarios funcionario);

	public void remover(Funcionarios funcionario);

	public Funcionarios procurar(int cpf);

	public void atualizar(int cpf, int idade);

	public boolean existe(int cpf);

}
