package funcionario;
public class Funcionarios {
	private String nome;
	private int idade;
	private int cpf;
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int idade() {
		return idade;
	}
	public void setFichaCriminal(int fichaCriminal) {
		this.idade = fichaCriminal;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	public Funcionarios(String nome,int idade) {
		this.nome=nome;
		this.idade=idade;
	}

}
