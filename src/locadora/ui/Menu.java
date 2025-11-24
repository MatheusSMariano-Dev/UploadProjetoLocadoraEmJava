package locadora.ui;

import locadora.model.Cliente;
import locadora.model.Filme;
import locadora.service.AluguelService;
import locadora.service.ClienteService;
import locadora.service.FilmeService;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
private ClienteService clienteService;
private FilmeService filmeService;
private AluguelService aluguelService;




    public Menu(ClienteService clienteService, FilmeService filmeService, AluguelService aluguelService) {
        this.clienteService = clienteService;
        this.filmeService = filmeService;
        this.aluguelService = aluguelService;

    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void setFilmeService(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    public void setAluguelService(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    public void iniciar() {
        Scanner sc = new Scanner(System.in);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== LOCADORA ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Filme");
            System.out.println("3 - Realizar Aluguel");
            System.out.println("4 - Devolver Filme");
            System.out.println("5 - Listar Clientes");
            System.out.println("6 - Listar Filmes");
            System.out.println("7 - Listar Aluguéis");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("nome ");
                    String nome = sc.nextLine();
                    System.out.println("cpf ");
                    String cpf = sc.nextLine();
                    System.out.println("telefone ");
                    String telefone = sc.nextLine();
                    System.out.println("email");
                    String email = sc.nextLine();
                    if (cpf.trim().isEmpty()) {
                        System.out.println("CPF INVALIDO, cadastro não realizado");
                        break;
                    }
                    if (telefone.trim().isEmpty()){
                        System.out.println("TELEFONE INVALIDO, cadastro não realizado");
                        break;
                    }
                    Cliente cliente = new Cliente(); cliente.setNome(nome); cliente.setCPF(Long.parseLong(cpf)); cliente.setTelefone(Long.parseLong(telefone)); cliente.setEmail(email);
                    clienteService.cadastrarCliente(cliente);
                    break;


                case 2:
                    System.out.println("Título do filme: ");
                    String titulo = sc.nextLine();

                    System.out.println("Gênero: ");
                    String genero = sc.nextLine();

                    System.out.println("Ano de lançamento: ");
                    String anoStr = sc.nextLine();

                    if (titulo.trim().isEmpty() || genero.trim().isEmpty() || !anoStr.matches("\\d+")) {
                        System.out.println("Dados inválidos. Cadastro de filme não realizado.");
                        break;
                    }

                    int ano = Integer.parseInt(anoStr);
                    LocalDate dataLancamento = LocalDate.of(ano, 1, 1);

                    Filme filme = new Filme();
                    filme.setNome(titulo);
                    filme.setCategoria(genero);
                    filme.setDatalancamento(dataLancamento);
                    filmeService.cadastrarFilme(filme);

                    System.out.println("Filme cadastrado com sucesso!");



                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                case 7:

                    break;

                case 0:
                    System.out.println("Operação finalizada.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();

    }
}
