package funcionario;
public class FuncionarioInexistenteException extends Exception {
public FuncionarioInexistenteException() {
	super("cpf n�o encontrado");
}
}
