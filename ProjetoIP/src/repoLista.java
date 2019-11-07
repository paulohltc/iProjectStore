
public class repoLista implements RepositorioFuncionarios{
private Funcionarios funcionario;
private repoLista proximo;
public repoLista() {
	this.funcionario=null;
	this.proximo=null;
}
public boolean contratar(Funcionarios funcionario) {
	boolean check=false;
	if(this.funcionario==null) {
		check=true;
		this.funcionario=funcionario;
		this.proximo=new repoLista();
	}else 
		this.proximo.contratar(funcionario);
	
	return check;
}
public boolean demitir(Funcionarios funcionario) {
	boolean check=false;
	if(this.funcionario!=null) {
		if(this.funcionario.getNome().equals(funcionario.getNome())) {
			check=true;
			this.funcionario=this.proximo.funcionario;
			this.proximo=this.proximo.proximo;
		}else 
			this.proximo.demitir(funcionario);
	}
	return check;
}
public int nFuncionarios() {
	int n=0;
	if(this.funcionario!=null) {
		n++;
		this.proximo.nFuncionarios();
	} return n;
}
}
