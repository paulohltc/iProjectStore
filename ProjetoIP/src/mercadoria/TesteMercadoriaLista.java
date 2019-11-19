package mercadoria;

public class TesteMercadoriaLista {

	public static void main(String[] args) throws MercadoriaNaoEncontradaException, MercadoriaJaCadastradaException {
		
		RepositorioMercadoriaLista repoTeste = new RepositorioMercadoriaLista();
		
		Mercadoria mercadorias = new Mercadoria ("Santo Graal", "Calice usado por Jesus na ultima ceia", 10.99, 666);
		repoTeste.inserir(mercadorias);
		System.out.println(repoTeste.existe(666));
		repoTeste.remover(666);
		System.out.println(repoTeste.existe(666));
		
		Mercadoria novaMerca = new Mercadoria ("Daniel Pacheco", "bonito (ele que disse)", 0.01, 20);
		repoTeste.inserir(novaMerca);
		System.out.println(repoTeste.existe(20));
		repoTeste.atualizar(20, 9.99);
		System.out.println(repoTeste.existe(novaMerca.getId())); 
		Mercadoria procura = repoTeste.procurar(20);
		System.out.println(procura.getNome() + ", " + procura.getDescricao() + ", " + procura.getPreco() + "\n");
		repoTeste.atualizar(20, 6.66);
		System.out.println(procura.getNome() + ", " + procura.getDescricao() + ", " + procura.getPreco() + "\n");
		repoTeste.remover(20);
		System.out.println(repoTeste.existe(20));
		
		Mercadoria venda = new Mercadoria ("Excalibur", "Espada do Rei Arthur", 12.99, 3);
		repoTeste.inserir(venda);
		Mercadoria procura2 = repoTeste.procurar(3);
		System.out.println(procura2.getNome() + ", " + procura2.getDescricao() + ", " + procura2.getPreco() + " \n");
		repoTeste.atualizar(3, 08.99);
		System.out.println(procura2.getNome() + ", " + procura2.getDescricao() + ", " + procura2.getPreco() + " \n");
		
		Mercadoria vendas = new Mercadoria ("Excalibur", "Espada do Rei Arthur", 12.99, 3);
		repoTeste.inserir(vendas);
		Mercadoria procura3 = repoTeste.procurar(3);
		System.out.println(procura3.getNome() + ", " + procura3.getDescricao() + ", " + procura3.getPreco() + " \n");
		
		
	}

}
