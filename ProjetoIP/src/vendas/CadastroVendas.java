package vendas;

public class CadastroVendas {
private VendasInterface vendas;
public CadastroVendas (VendasInterface repo) {
	vendas=repo;
}

public void VendaInserir (Sale sale) throws ExisteVendaException{
	this.vendas.VendaInserir(sale);
}

public void VendaRemover (String id) throws NaoExisteException {
	this.vendas.VendaRemover(id);
}

public boolean VendaExiste (String id) throws NaoExisteException{
	return this.vendas.VendaExiste(id);
}

public void VendaAtualizar (Sale sale) throws NaoExisteException {
	this.vendas.VendaAtualizar(sale);
}

public Sale VendaProcurar (String id) throws NaoExisteException {
	return this.vendas.VendaProcurar(id);
}
}
