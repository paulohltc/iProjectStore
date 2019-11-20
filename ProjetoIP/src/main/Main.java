package main;
 
import fachada.LojaMagica;
import mercadoria.*;
import Cliente.*;
import funcionario.*;
import entregador.*;
import Pessoa.*;
import vendas.*;
 
import java.util.*;
 
//main interativo, interface no console
 
public class Main {
 
    public static void main(String[] args) throws MercadoriaJaCadastradaException, MercadoriaNaoEncontradaException,
            ClienteJaCadastradoException, ClienteNaoEncontradoException, LimiteClientesAtingidoException,
            EntregadorJaCadastroException, EntregadorNaoEncontradoException, FuncionarioInexistenteException,
            FuncionarioJaCadastradoException, ExisteVendaException, LongeException, NaoExisteException {
        Scanner in = new Scanner(System.in);
 
        int entrada = 0, tipoPessoa = 0;
 
        Mercadoria objetoMercadoria;
        Cliente objetoCliente;
        Funcionarios objetoFuncionario;
        Entregador objetoEntregador;
        Sale objetoVendas;
 
        // lista
        RepositorioMercadoria repoMercadoria = new RepositorioMercadoriaLista();
        RepositorioCliente repoCliente = new RepositorioListaCliente();
        RepositorioEntregadores repoEntregador = new RepositorioEntregadoresLista();
        RepositorioFuncionarios repoFuncionarios = new RepositorioFuncionariosLista();
        VendasInterface repoVendas = new RepositorioListaVendas();
        LojaMagica lojaMagica = new LojaMagica(repoMercadoria, repoVendas, repoEntregador, repoCliente,
                repoFuncionarios);
 
        // array
        // RepositorioMercadoria repoMercadoria = new RepositorioMercadoriaArray();
        // RepositorioCliente repoCliente = new RepositorioArrayCliente();
        // RepositorioEntregadores repoEntregador = new RepositorioEntregadoresArray();
        // RepositorioFuncionarios repoFuncionarios = new
        // RepoositorioFuncionariosArray();
        // VendasInterface repoVendas = new RepositorioArrayVendas();
        // LojaMagica lojaMagica = new LojaMagica(repoMercadoria, repoVendas,
        // repoEntregador,
        // repoCliente, repoFuncionarios);
 
        System.out.println("Ola! Bem vindo a nossa Loja Magica! \n");
 
        while (entrada != 5) {
            int opcao = 0;
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Gerenciar mercadoria");
            System.out.println("2 - Gerenciar vendas");
            System.out.println("3 - Gerenciar pessoas");
            System.out.println("4 - Gerenciar clientes");
            System.out.println("5 - Sair \n");
 
            entrada = in.nextInt();
 
            // mercadoria
            if (entrada == 1) {
                while (opcao != 5) {
                    System.out.println("Voce esta no gerenciamento de mercadorias. Selecione o que deseja fazer.");
                    System.out.println("1 - Cadastrar mercadoria");
                    System.out.println("2 - Remover mercadoria");
                    System.out.println("3 - Atualizar preco da mercadoria");
                    System.out.println("4 - Procurar mercadoria");
                    System.out.println("5 - Sair \n");
 
                    opcao = in.nextInt();
 
                    // cadastrar mercadoria
                    if (opcao == 1) {
 
                        System.out.println("Para cadastrar uma mercadoria, digite o que se pede:");
                        System.out.println("Nome da mercadoria: ");
                        String nomeM = in.nextLine();
                        System.out.println("Descricao da mercadoria: ");
                        String descricaoM = in.nextLine();
                        System.out.println("Preco da mercadoria: ");
                        double precoM = in.nextDouble();
                        System.out.println("Identificador da mercadoria: ");
                        int idM = in.nextInt();
 
                        try {
 
                            Mercadoria objMercadoria = new Mercadoria(nomeM, descricaoM, precoM, idM);
                            lojaMagica.cadastrarMercadoria(objMercadoria);
                            System.out.println("\n\nMercadoria cadastrada com sucesso!\n\n");
 
                        } catch (MercadoriaJaCadastradaException e) {
                            System.out.println("\n\n******ERRO******\n\n");
                            System.out.println(e.getMessage() + "\n");
                        }
 
                    }
 
                    // remover mercadoria
                    if (opcao == 2) {
 
                        System.out.println("Para remover uma mercadoria, digite o que se pede:");
                        System.out.println("Identificador da mercadoria");
                        int idM = in.nextInt();
 
                        try {
 
                            lojaMagica.removerMercadoria(idM);
                            System.out.println("\n\nMercadoria removida com sucesso!\n\n");
 
                        } catch (MercadoriaNaoEncontradaException e) {
                            System.out.println("\n\n******ERRO******\n\n");
                            System.out.println(e.getMessage() + "\n");
                        }
                    }
 
                    // atualizar preco
                    if (opcao == 3) {
 
                        System.out.println("Para atualizar o preco de uma mercadoria, digite o que se pede: ");
                        System.out.println("Identificador da mercadoria");
                        int idM = in.nextInt();
 
                        try {
                            lojaMagica.existeMercadoria(idM);
                            System.out.println("Insira o novo nome da mercadoria");
                            String nomeM = in.nextLine();
                   
                            System.out.println("Insira o novo preco da mercadoria");
                            double precoM = in.nextDouble();
                            Mercadoria objMercadoria = new Mercadoria(idM, precoM);
                            lojaMagica.atualizarMercadoria(objMercadoria);
 
                        } catch (MercadoriaNaoEncontradaException e) {
                            System.out.println("\n\n******ERRO******\n\n");
                            System.out.println(e.getMessage() + "\n");
                        }
 
                    }
 
                    // procurar mercadoria
                    if (opcao == 4) {
 
                        System.out.println("Para procurar uma mercadoria, digite o que se pede: ");
                        System.out.println("Identificador da mercadoria");
                        int idM = in.nextInt();
 
                        try {
 
                            Mercadoria mercadoriaProcurada = lojaMagica.procurarMercadoria(idM);
                            System.out.println("Nome da mercadoria: " + mercadoriaProcurada.getNome());
                            System.out.println("Descricao da mercadoria: " + mercadoriaProcurada.getDescricao());
                            System.out.println("Preco da mercadoria: " + mercadoriaProcurada.getPreco());
                            System.out.println("\n\n");
 
                        } catch (MercadoriaNaoEncontradaException e) {
                            System.out.println("\n\n******ERRO******\n\n");
                            System.out.println(e.getMessage() + "\n");
                        }
 
                    }
                   
                }
            }
 
            // vendas
            if (entrada == 2) {
                while (opcao != 5) {
                    System.out.println("Voce esta no gerenciamento de vendas. Selecione o que deseja fazer.");
                    System.out.println("1 - Cadastrar vendas");
                    System.out.println("2 - Remover vendas");
                    System.out.println("3 - Atualizar vendas");
                    System.out.println("4 - Procurar vendas");
                    System.out.println("5 - Sair \n");
 
                    opcao = in.nextInt();
 
                    // cadastro venda
                    if (opcao == 1) {
 
                    }
 
                    // remover venda
                    if (opcao == 2) {
 
                    }
 
                    // atualizar venda
                    if (opcao == 3) {
 
                    }
 
                    // procurar venda
                    if (opcao == 4) {
 
                    }
                }
            }
 
            // pessoas
            if (entrada == 3) {
                while (tipoPessoa != 3) {
                    System.out.println("Voce esta no gerenciamento de pessoas. Selecione o que deseja fazer.");
                    System.out.println("1 - Gerenciar entregadores");
                    System.out.println("2 - Gerenciar funcionarios");
                    System.out.println("3 - Sair \n");
 
                    tipoPessoa = in.nextInt();
 
                    // entregadores
                    if (tipoPessoa == 1) {
                        System.out.println("Voce esta no gerenciamento de entregadores. Selecione o que deseja fazer.");
                        System.out.println("1 - Cadastrar entregador");
                        System.out.println("2 - Remover entregador");
                        System.out.println("3 - Atualizar entregador");
                        System.out.println("4 - Procurar entregador");
                        System.out.println("5 - Sair \n");
 
                        opcao = in.nextInt();
 
                        // cadastrar entregador
                        if (opcao == 1) {
 
                        }
 
                        // remover entregador
                        if (opcao == 2) {
 
                        }
 
                        // atualizar entregador
                        if (opcao == 3) {
 
                        }
 
                        // procurar entregador
                        if (opcao == 4) {
 
                        }
                    }
 
                    // funcionarios
                    if (tipoPessoa == 2) {
                        System.out.println("Voce esta no gerenciamento de funcionarios. Selecione o que deseja fazer.");
                        System.out.println("1 - Cadastrar funcionarios");
                        System.out.println("2 - Remover funcionarios");
                        System.out.println("3 - Atualizar funcionarios");
                        System.out.println("4 - Procurar funcionarios");
                        System.out.println("5 - Sair \n");
 
                        opcao = in.nextInt();
 
                        // cadastrar funcionario
                        if (opcao == 1) {
 
                        }
 
                        // remover funcionario
                        if (opcao == 2) {
 
                        }
 
                        // atualizar funcionario
                        if (opcao == 3) {
 
                        }
 
                        // procurar funcionario
                        if (opcao == 4) {
 
                        }
                    }
                }
                
                //clientes
                if (entrada == 4) {
                	while (opcao != 5) {
                        System.out.println("Voce esta no gerenciamento de clientes. Selecione o que deseja fazer.");
                        System.out.println("1 - Cadastrar cliente");
                        System.out.println("2 - Remover cliente");
                        System.out.println("3 - Atualizar cliente");
                        System.out.println("4 - Procurar cliente");
                        System.out.println("5 - Sair \n");
     
                        opcao = in.nextInt();
                        
                     // cadastrar cliente
                        if (opcao == 1) {
 
                        }
 
                        // remover cliente
                        if (opcao == 2) {
 
                        }
 
                        // atualizar cliente
                        if (opcao == 3) {
 
                        }
 
                        // procurar cliente
                        if (opcao == 4) {
 
                        }
                }
 
            }
 
        }
    }
}}