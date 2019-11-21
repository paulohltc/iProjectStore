package funcionario;

import vendas.ExisteVendaException;
import vendas.NaoExisteException;
import vendas.Vendas;

public class RepositorioFuncionariosArray implements RepositorioFuncionarios {
	private Funcionarios funcionarios[];
	int size;

	public RepositorioFuncionariosArray() {
		
	}
	public void inserir(Funcionarios funcionario){
		Funcionarios[] aux = new Funcionarios[size + 1];
		for (int i = 0; i <= size; i++) {
			if (i < size)
				aux[i] = funcionarios[i];
			else
				aux[i] = funcionario;
		}
		size++;
		funcionarios = aux;
	}

	public void remover(Funcionarios funcionario){
		Funcionarios[] aux = new Funcionarios[size - 1];
		boolean removeu = false;
		for (int i = 0; i < size; i++) {
			if (!removeu&&funcionarios[i].equals(funcionario)) {
				removeu=true;
				aux[i] = funcionarios[i+1];
				i++;
			}
			else if(!removeu&&i==size-1&&!funcionarios[i+1].equals(funcionario)) {
			i++;	
			}
			else
				aux[i] = funcionarios[i];
		}
		size--;
		funcionarios=aux;
	}

	public void atualizar (Funcionarios funcionario,String cpf){
		for (int i = 0; i < size; i++) {
			if (funcionarios[i].getCpf().equals(cpf)) {
				funcionarios[i] = funcionario;
				i=size;
			}
		}
	}

	public Funcionarios procurar(String cpf) {
		for (int i = 0; i < size; i++) {
			if (this.funcionarios[i].getCpf().equals(cpf) )
				return this.funcionarios[i];

		}
		return null;
	}

	public boolean existe(String cpf) {
		for (int i = 0; i < size; i++) {
			if(this.funcionarios[i].getCpf().equals(cpf)) {
				return true;
			}
		}return false;
	}
}
