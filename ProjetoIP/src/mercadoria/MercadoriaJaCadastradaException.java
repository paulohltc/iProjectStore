package mercadoria;

public class MercadoriaJaCadastradaException extends Exception {
	public MercadoriaJaCadastradaException() {
		super("Mercadoria já cadastrada.");
	}

}
