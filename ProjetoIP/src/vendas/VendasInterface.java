package vendas;

public interface VendasInterface {
	public void VendaInserir(Sale sale)
			throws ExisteVendaException;
			public void VendaAtualizar(Sale sale)
			throws NaoExisteException;
			public void VendaRemover(String saleid)
			throws NaoExisteException;
			public Sale VendaProcurar(String saleid)
			throws NaoExisteException;
			public boolean VendaExiste(String saleid)
			throws NaoExisteException;
}
