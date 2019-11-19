package mercadoria;

public class TesteArrayMercadoria {

	public static void main(String[] args) throws MercadoriaNaoEncontradaException, MercadoriaJaCadastradaException {
		
		RepositorioMercadoriaLista repoTeste = new RepositorioMercadoriaLista();
		
		// Teste 1
		Mercadoria venda = new Mercadoria ("Excalibur", "Espada do Rei Arthur", 12.99, 3);
		repoTeste.inserir(venda);
		Mercadoria procura = repoTeste.procurar(3);
		System.out.println(procura.getNome() + ", " + procura.getDescricao() + ", " + procura.getPreco() + " \n");
		repoTeste.atualizar(3, 10.00);
		System.out.println(procura.getNome() + ", " + procura.getDescricao() + ", " + procura.getPreco() + " \n");
		System.out.println(repoTeste.existe(3));
		repoTeste.remover(3);
		System.out.println(repoTeste.existe(3));
		
		//Teste2
		Mercadoria venda2 = new Mercadoria ("Capa de Invisibilidade", "Parte das reliquias da morte", 18.99, 4);
		repoTeste.inserir(venda2);
		Mercadoria procura2 = repoTeste.procurar(4);
		System.out.println(procura2.getNome() + ", " + procura2.getDescricao() + ", " + procura2.getPreco() + " \n");
		repoTeste.atualizar(4, 9.00);
		System.out.println(procura2.getNome() + ", " + procura2.getDescricao() + ", " + procura2.getPreco() + " \n");
		repoTeste.remover(4);
		System.out.println(repoTeste.existe(4));
		
		

	}

}
