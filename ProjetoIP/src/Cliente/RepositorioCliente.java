package Cliente;
public interface RepositorioCliente {
	
	void atualizar(Cliente cliente) throws ClienteNaoEncontradoException;
	
	void remover(String cpf) throws ClienteNaoEncontradoException;
	
	Cliente procurar(String cpf) throws ClienteNaoEncontradoException;
        
	boolean existe(String cpf);
	
	void inserir(Cliente cliente); 
}