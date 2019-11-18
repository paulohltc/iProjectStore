package Cliente;

public class Cliente {

	private String cpf;
	private String nome;
	private String especie;
	private String contato;
	
	public Cliente(String nome, String cpf, String especie, String contato) {
		this.nome = nome;
		this.cpf = cpf;
		this.especie = especie;
		this.contato = contato;
}
	public String getEspecie() { return especie; }
    
    public String getContato() { return contato; }
    
    public String getCpf() { return cpf; }
}
