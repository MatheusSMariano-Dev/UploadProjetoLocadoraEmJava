
package locadora.service;

import locadora.model.Aluguel;
import locadora.model.Cliente;
import locadora.model.Filme;
import locadora.repository.AluguelRepository;
import locadora.repository.ClienteRepository;
import locadora.repository.FilmeRepository;

import java.time.LocalDateTime;
import java.util.List;

public class AluguelService {

    private final AluguelRepository aluguelRepository;
    private final ClienteRepository clienteRepository;
    private final FilmeRepository filmeRepository;

    public AluguelService(AluguelRepository aluguelRepository, ClienteRepository clienteRepository, FilmeRepository filmeRepository) {
        this.aluguelRepository = aluguelRepository;
        this.clienteRepository = clienteRepository;
        this.filmeRepository = filmeRepository;
    }

    public Aluguel realizarAluguel(long idCliente, long idFilme) {
        Cliente cliente = clienteRepository.findById(idCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return null;
        }

        Filme filme = filmeRepository.findById(idFilme);
        if (filme == null) {
            System.out.println("Filme não encontrado!");
            return null;
        }

        for (Aluguel a : aluguelRepository.listarTodos()) {
            if (a.getFilme() != null && a.getFilme().getId() == idFilme && a.getDataHoraDevolucao() == null) {
                System.out.println("Filme já está alugado!");
                return null;
            }
        }

        Aluguel aluguel = new Aluguel();
        aluguel.setCliente(cliente);
        aluguel.setFilme(filme);
        aluguel.setDataHoraAluguel(LocalDateTime.now());

        aluguelRepository.salvar(aluguel);
        return aluguel;
    }

    public Aluguel realizarDevolucao(long idAluguel) {
        Aluguel aluguel = aluguelRepository.findById(idAluguel);
        if (aluguel == null) {
            System.out.println("Aluguel não encontrado!");
            return null;
        }

        if (aluguel.getDataHoraDevolucao() != null) {
            System.out.println("Filme já devolvido!");
            return null;
        }

        aluguel.setDataHoraDevolucao(LocalDateTime.now());
        double total = aluguel.calcularValor();
        aluguel.setValorTotal(total);

        System.out.println("Filme devolvido! Valor total: R$ " + String.format("%.2f", total));
        aluguelRepository.atualizar(aluguel);
        return aluguel;
    }

    public List<Aluguel> listarAlugueis() {
        return aluguelRepository.listarTodos();
    }
}
