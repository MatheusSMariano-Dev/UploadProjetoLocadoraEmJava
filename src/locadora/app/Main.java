package locadora.app;

import locadora.repository.AluguelRepository;
import locadora.repository.ClienteRepository;
import locadora.repository.FilmeRepository;
import locadora.service.AluguelService;
import locadora.service.ClienteService;
import locadora.service.FilmeService;
import locadora.ui.Menu;


public class Main {
    public static void main(String[] args) {

        ClienteRepository clienteRepository = new ClienteRepository();
        FilmeRepository filmeRepository = new FilmeRepository();
        AluguelRepository aluguelRepository = new AluguelRepository();

        ClienteService clienteService = new ClienteService(clienteRepository);
        FilmeService filmeService = new FilmeService(filmeRepository);
        AluguelService aluguelService = new AluguelService(aluguelRepository, clienteRepository, filmeRepository);

        Menu menu = new Menu(clienteService, filmeService, aluguelService);
        menu.iniciar();


    }

}
