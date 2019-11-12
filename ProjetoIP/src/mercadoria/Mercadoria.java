package mercadoria;

public class Mercadoria {
	private String nome;
	private String descricao;
	private int id;
	private int estoque;
	private double preco;
	private double peso;
	
	public Mercadoria(String nome, String descricao, int estoque, double preco, double peso) {
		this.nome = nome;
		this.descricao = descricao;
		this.estoque = estoque;
		this.preco = preco;
		this.peso = peso;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
