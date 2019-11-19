package funcionario;
public interface RepositorioFuncionarios {
	public void inserir(Funcionarios funcionario);

	public void remover(Funcionarios funcionario);

	public Funcionarios procurar(String cpf);

	public void atualizar(Funcionarios funcionario,String cpf);

	public boolean existe(String cpf);

}
