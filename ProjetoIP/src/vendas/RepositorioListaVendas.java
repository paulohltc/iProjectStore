package vendas;

public class RepositorioListaVendas implements VendasInterface{
	private Sale sale;
	private RepositorioListaVendas next;

	public RepositorioListaVendas() {
		this.sale = null;
		this.next = null;
	}

	public RepositorioListaVendas(Sale sale) {
		this.sale = sale;
		this.next = null;
	}

	public void VendaInserir(Sale sale) throws ExisteVendaException {
		if (this.sale == null) {
			this.sale = sale;
			this.next = new RepositorioListaVendas();
		} else if (this.sale == null) {
			throw new ExisteVendaException();
		} else {
			this.next.VendaInserir(sale);
		}
	}
	public void VendaRemover(String saleid) throws NaoExisteException{
		if(this.sale!=null) {
			if(saleid.equals(this.sale.getSaleid())) {
				this.sale=this.next.sale;
				this.next=this.next.next;
			}
			else if(this.next==null) {
				throw new NaoExisteException();
			}
			else {
				this.next.VendaRemover(saleid);
			}
		}
	}
	public boolean VendaExiste(String saleid) throws NaoExisteException{
		if(this.sale!=null&&saleid==this.sale.getSaleid()) {
			return true;
		}
		else if(this.next==null) {
			throw new NaoExisteException();
		}
		else {
			return this.next.VendaExiste(saleid);
		}
	}
	public Sale VendaProcurar(String saleid) throws NaoExisteException{
		if(this.sale!=null&&this.sale.getSaleid()==saleid) {
			return sale;
		}
		else if(this.next==null)
			throw new NaoExisteException();
		else {
			return this.next.VendaProcurar(saleid);
		}
	}
	public void VendaAtualizar(Sale sale) throws NaoExisteException{
		if(this.sale.getSaleid()==sale.getSaleid()) {
			this.sale=sale;
		}
		else if(this.next!=null) {
			this.next.VendaAtualizar(sale);
		}
		else {
			throw new NaoExisteException();	
		}
	}


}