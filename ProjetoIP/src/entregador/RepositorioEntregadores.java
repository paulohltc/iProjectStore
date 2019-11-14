package entregador;

public interface RepositorioEntregadores {
	public void inserirEntregador(Entregador entregador) throws EntregadorJaCadastroException;

	public void removerEntregador(String cpf) throws EntregadorNaoEncontradoException;

	public boolean verificarEntregador(String cpf);

	public void atualizarTransporteEntregador(String cpf, String transporte) throws EntregadorNaoEncontradoException;

	public Entregador procurarEntregador(String cpf) throws EntregadorNaoEncontradoException;

}
