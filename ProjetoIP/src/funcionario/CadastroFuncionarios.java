package funcionario;
public class CadastroFuncionarios {
private RepositorioFuncionarios repositorioFuncionarios;
public CadastroFuncionarios(RepositorioFuncionarios repositorioFuncionarios) {
	this.repositorioFuncionarios=repositorioFuncionarios;
}
public void cadastrarFuncionarios(Funcionarios funcionario) throws FuncionarioJaCadastradoException  {
	if(repositorioFuncionarios.existe(funcionario.getCpf())==false)
	repositorioFuncionarios.inserir(funcionario);
	else 
		throw new FuncionarioJaCadastradoException();
}
public void  removerFuncionarios(Funcionarios funcionario) throws FuncionarioInexistenteException{
	if(repositorioFuncionarios.existe(funcionario.getCpf())==false)
		repositorioFuncionarios.remover(funcionario);
	else 
		throw new FuncionarioInexistenteException();
}
public void atualizarFuncioanrios(Funcionarios funcionario) throws FuncionarioInexistenteException{
	if(repositorioFuncionarios.existe(funcionario.getCpf())==false)
		repositorioFuncionarios.atualizar(funcionario.getCpf(), funcionario.getIdade());
	else 
		throw new FuncionarioInexistenteException();
}
public Funcionarios procurarFuncionario(int cpf)throws FuncionarioInexistenteException {
	if(repositorioFuncionarios.existe(cpf)==true) 
		throw new FuncionarioInexistenteException();
	
	return repositorioFuncionarios.procurar(cpf);
	
		
}
}
