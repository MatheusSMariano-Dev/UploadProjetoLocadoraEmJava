package locadora.service;

import locadora.model.Cliente;
import locadora.repository.ClienteRepository;

import java.util.List;

public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrarCliente(Cliente cliente){
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            return null;
        }
        if (cliente.getCPF() <= 0) {
            return null;
        }
        if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
            return null;
        }
        if (cliente.getTelefone() <= 0) {
            return null;
        }

        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}
