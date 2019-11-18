package funcionario;
public interface RepositorioFuncionarios {
	public void inserir(Funcionarios funcionario);

	public void remover(Funcionarios funcionario);

	public Funcionarios procurar(int cpf);

	public void atualizar(Funcionarios funcionario,int cpf);

	public boolean existe(int cpf);

}
