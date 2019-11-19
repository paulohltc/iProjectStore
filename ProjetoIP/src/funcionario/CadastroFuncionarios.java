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
public void atualizarFuncioanrios(Funcionarios funcionario,String cpf) throws FuncionarioInexistenteException{
	if(repositorioFuncionarios.existe(funcionario.getCpf())==false)
		repositorioFuncionarios.atualizar(funcionario,cpf);
	else 
		throw new FuncionarioInexistenteException();
}
public Funcionarios procurarFuncionario(String cpf)throws FuncionarioInexistenteException {
	if(repositorioFuncionarios.existe(cpf)==true) 
		throw new FuncionarioInexistenteException();
	
	return repositorioFuncionarios.procurar(cpf);
	
		
}
public void inserir(Funcionarios funcionario) {
	this.repositorioFuncionarios.inserir(funcionario);
}
public void remover(Funcionarios funcionario) {
	this.repositorioFuncionarios.remover (funcionario);
}
public boolean existe(String cpf) {
	return this.repositorioFuncionarios.existe(cpf);
}
public Funcionarios procurar(String cpf) {
	return this.repositorioFuncionarios.procurar(cpf);
}
public void atualizar(Funcionarios funcionario,String cpf) {
	this.repositorioFuncionarios.atualizar (funcionario,cpf);
}
}
