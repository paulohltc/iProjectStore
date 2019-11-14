package entregador;

public class Entregador {
	private String nome;
	private String cpf;
	private String transporte;
	private int QuantidadeEntregas;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTransporte() {
		return transporte;
	}
	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}
	public int getQuantidadeEntregas() {
		return QuantidadeEntregas;
	}
	public void setQuantidadeEntregas(int quantidadeEntregas) {
		QuantidadeEntregas = quantidadeEntregas;
	}

}