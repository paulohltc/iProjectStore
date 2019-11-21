package entregador;

public class EntregadorNaoExisteException extends Exception{
	public EntregadorNaoExisteException() {
		super("Nao existe nenhum entregador");
	}
}
	