package vendas;

public class RepositorioArrayVendas implements VendasInterface {
	int size = 0;
	Sale[] Repoa = new Sale[size];

	public void VendaInserir(Sale sale) throws ExisteVendaException{
		Sale[] aux = new Sale[size + 1];
		for (int i = 0; i <= size; i++) {
			if (i < size)
				aux[i] = Repoa[i];
			else if(Repoa[i]==sale)
				throw new ExisteVendaException();
			else
				aux[i] = sale;
		}
		size++;
		Repoa = aux;
	}

	public void VendaRemover(String saleid) throws NaoExisteException{
		Sale[] aux = new Sale[size - 1];
		boolean removeu = false;
		for (int i = 0; i < size; i++) {
			if (Repoa[i].getSaleid().equals(saleid)) {
				removeu=true;
				aux[i] = Repoa[i+1];
				i++;
			}
			else if(!removeu&&i==size-1&&!Repoa[i+1].getSaleid().equals(saleid)) {
			i++;	
			}
			else
				aux[i] = Repoa[i];
		}

	}

	public void VendaAtualizar(Sale sale) throws NaoExisteException {
		for (int i = 0; i < size; i++) {
			if (Repoa[i].getSaleid().equals(sale.getSaleid()))
				Repoa[i] = sale;
			else if (i == size - 1)
				throw new NaoExisteException();
		}
	}

	public Sale VendaProcurar(String saleid) throws NaoExisteException {
		Sale sale = null;
		for (int i = 0; i < size; i++) {
			if (Repoa[i].getSaleid().equals(saleid))
				sale = Repoa[i];
		}
		if (sale != null) {
			return sale;
		} else {
			throw new NaoExisteException();
		}
	}

	public boolean VendaExiste(String saleid) throws NaoExisteException {
		boolean aa = false;
		for (int i = 0; i < size; i++) {
			if (Repoa[i].getSaleid().equals(saleid))
				aa = true;
		}
		if (aa) {
			return aa;
		} else {
			throw new NaoExisteException();
		}
	}

}
