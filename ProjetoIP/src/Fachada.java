import java.util.Scanner;

public class Fachada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		repoArray array = new repoArray();
		repoLista lista = new repoLista();
		while (in.hasNext()) {
			String tipoRepositorio = in.nextLine();
			String comando = in.nextLine();
			String nome = in.nextLine();
			String fichaCriminal = in.nextLine();
			int diasServico = 0;
			Funcionarios funcionario = new Funcionarios(nome, fichaCriminal, diasServico);
			if (tipoRepositorio.equalsIgnoreCase("array")) {
				if (comando.equalsIgnoreCase("contratar"))
					System.out.println(array.contratar(funcionario));
				else
					System.out.println(array.demitir(funcionario));
			} else if (tipoRepositorio.equalsIgnoreCase("lista")) {
				if (comando.equalsIgnoreCase("contratar")) {
					System.out.println(lista.contratar(funcionario));
				} else
					System.out.println(lista.demitir(funcionario));
					
			}
		}
	}

}
