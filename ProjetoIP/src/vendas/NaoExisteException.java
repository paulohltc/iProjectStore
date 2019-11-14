package vendas;

public class NaoExisteException extends Exception{
	public NaoExisteException() {
		super("essa conta nao existe");
		}
}
