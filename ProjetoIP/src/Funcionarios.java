
public class Funcionarios {
	private String nome;
	private String fichaCriminal;
	public String getFichaCriminal() {
		return fichaCriminal;
	}
	public void setFichaCriminal(String fichaCriminal) {
		this.fichaCriminal = fichaCriminal;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	public Funcionarios(String nome,String ficha,int dias) {
		this.nome=nome;
		this.fichaCriminal=fichaCriminal;
	}

}
