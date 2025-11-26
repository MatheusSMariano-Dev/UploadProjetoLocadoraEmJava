package locadora.ui;

import locadora.model.Aluguel;
import locadora.model.Cliente;
import locadora.model.Filme;
import locadora.service.AluguelService;
import locadora.service.ClienteService;
import locadora.service.FilmeService;

import java.time.LocalDate;
import java.util.List;
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
            System.out.println("\n LOCADORA ESSENCIAL ");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Filme");
            System.out.println("3 - Realizar Aluguel");
            System.out.println("4 - Devolver Filme");
            System.out.println("5 - Listar Clientes");
            System.out.println("6 - Listar Filmes");
            System.out.println("7 - Listar Aluguéis");
            System.out.println("0 - Sair");

            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número.");
                continue;
            }

            switch (opcao) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    if (cpf.trim().isEmpty()) {
                        System.out.println("CPF INVÁLIDO, cadastro não realizado");
                        break;
                    }
                    if (telefone.trim().isEmpty()) {
                        System.out.println("TELEFONE INVÁLIDO, cadastro não realizado");
                        break;
                    }

                    try {
                        Cliente cliente = new Cliente();
                        cliente.setNome(nome);
                        cliente.setCPF(Long.parseLong(cpf));
                        cliente.setTelefone(Long.parseLong(telefone));
                        cliente.setEmail(email);

                        Cliente salvo = clienteService.cadastrarCliente(cliente);
                        if (salvo != null) {
                            System.out.println("Cliente cadastrado com sucesso! ID: " + salvo.getId());
                        } else {
                            System.out.println("Dados inválidos. Cadastro não realizado.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("CPF ou telefone inválido, cadastro não realizado");
                    }
                    break;

                case 2:
                    System.out.print("Título do filme: ");
                    String titulo = sc.nextLine();
                    System.out.print("Gênero: ");
                    String genero = sc.nextLine();
                    System.out.print("Ano de lançamento: ");
                    String anoStr = sc.nextLine();
                    System.out.print("Valor por hora: ");
                    String valorStr = sc.nextLine();

                    if (titulo.trim().isEmpty() || genero.trim().isEmpty() || !anoStr.matches("\\d+") || !valorStr.matches("\\d+(\\.\\d+)?")) {
                        System.out.println("Dados inválidos. Cadastro de filme não realizado.");
                        break;
                    }

                    try {
                        int ano = Integer.parseInt(anoStr);
                        double valor = Double.parseDouble(valorStr);

                        Filme filme = new Filme();
                        filme.setNome(titulo);
                        filme.setCategoria(genero);
                        filme.setDatalancamento(LocalDate.of(ano, 1, 1));
                        filme.setValorPorHora(valor);

                        Filme salvo = filmeService.cadastrarFilme(filme);

                        if (salvo != null) {
                            System.out.println("Filme cadastrado com sucesso! ID: " + salvo.getId());
                        } else {
                            System.out.println("Dados inválidos. Cadastro não realizado.");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar filme.");
                    }
                    break;


                case 3:
                    System.out.print("ID do Cliente: ");
                    String idClienteStr = sc.nextLine();
                    System.out.print("ID do Filme: ");
                    String idFilmeStr = sc.nextLine();

                    if (idClienteStr.trim().isEmpty() || idFilmeStr.trim().isEmpty()) {
                        System.out.println("IDs inválidos, aluguel não realizado");
                        break;
                    }

                    try {
                        long idCliente = Long.parseLong(idClienteStr);
                        long idFilme = Long.parseLong(idFilmeStr);

                        Aluguel resultado = aluguelService.realizarAluguel(idCliente, idFilme);
                        if (resultado != null) {
                            System.out.println("Aluguel realizado com sucesso! Aluguel ID: " + resultado.getId());
                        } else {
                            System.out.println("Não foi possível realizar o aluguel.");
                        }
                    } catch (Exception e) {
                        System.out.println("IDs inválidos, aluguel não realizado");
                    }
                    break;

                case 4:
                    System.out.print("ID do aluguel: ");
                    String idAluguelStr = sc.nextLine();

                    if (idAluguelStr.trim().isEmpty()) {
                        System.out.println("ID inválido, devolução não realizada");
                        break;
                    }

                    try {
                        long idAluguel = Long.parseLong(idAluguelStr);
                        Aluguel devolucao = aluguelService.realizarDevolucao(idAluguel);

                        if (devolucao != null) {
                            System.out.println("Filme devolvido! Valor total: R$ " + devolucao.getValorTotal());
                        } else {
                            System.out.println("Não foi possível devolver o filme.");
                        }
                    } catch (Exception e) {
                        System.out.println("ID inválido, devolução não realizada");
                    }
                    break;

                case 5:
                    System.out.println("Lista de Clientes:");
                    List<Cliente> clientes = clienteService.listarClientes();

                    if (clientes == null || clientes.isEmpty()) {
                        System.out.println("(Nenhum cliente cadastrado)");
                    } else {
                        for (Cliente c : clientes) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Lista de Filmes:");
                    List<Filme> filmes = filmeService.listarFilmes();

                    if (filmes == null || filmes.isEmpty()) {
                        System.out.println("(Nenhum filme cadastrado)");
                    } else {
                        for (Filme f : filmes) {
                            System.out.println(f);
                        }
                    }
                    break;

                case 7:
                    System.out.println("Lista de Aluguéis:");
                    List<Aluguel> alugueis = aluguelService.listarAlugueis();

                    if (alugueis == null || alugueis.isEmpty()) {
                        System.out.println("(Nenhum aluguel registrado)");
                    } else {
                        for (Aluguel a : alugueis) {
                            System.out.println(a);
                        }
                    }
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
