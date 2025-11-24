package locadora.service;

import locadora.model.Aluguel;
import locadora.model.Cliente;
import locadora.model.Filme;
import locadora.repository.AluguelRepository;
import locadora.repository.ClienteRepository;
import locadora.repository.FilmeRepository;

import java.time.LocalDateTime;

public class AluguelService {
    private AluguelRepository aluguelRepository;
    private ClienteRepository clienteRepository;
    private FilmeRepository filmeRepository;

    public AluguelService(AluguelRepository aluguelRepository, ClienteRepository clienteRepository, FilmeRepository filmeRepository) {
        this.aluguelRepository = aluguelRepository;
        this.clienteRepository = clienteRepository;
        this.filmeRepository = filmeRepository;


    }

    public Aluguel realizarAluguel(long idCliente, long idFilme) {

        Cliente cliente = clienteRepository.findById(idCliente);
        if (cliente == null) {
            return null;
        }


        Filme filme = filmeRepository.findById(idFilme);
        if (filme == null) {
            return null;
        }

                for (Aluguel aluguel : aluguelRepository.findAll()) {
                    if (aluguel.getFilme().getId() == idFilme) {


                        if (aluguel.getDataHoraDevolucao() == null) {
                            return null;
                        }
                    }

                }

        Aluguel aluguel = new Aluguel();
        aluguel.setCliente(cliente);
        aluguel.setFilme(filme);
        aluguel.setDataHoraAluguel(LocalDateTime.now());
        return aluguelRepository.save(aluguel);

    }

    public Aluguel realizarDevolucao(long idAluguel){
    Aluguel aluguel = aluguelRepository.findById(idAluguel);
    if (aluguel == null) {
        return null;
    }
         if (aluguel.getDataHoraDevolucao() != null){
             return null;
         }

        aluguel.setDataHoraDevolucao(LocalDateTime.now());

        double total = aluguel.calcularValor();
        aluguel.setValorTotal(total);
        return aluguel;
    }


}