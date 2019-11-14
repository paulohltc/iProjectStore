package vendas;

public class ExisteVendaException extends Exception{
	public ExisteVendaException() {
		super("Essa conta ja existe");
		}
}
