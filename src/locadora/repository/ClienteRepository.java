package locadora.repository;

import locadora.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private long idCounter = 1;
    private List<Cliente> clientes = new ArrayList<>();

    public Cliente save(Cliente cliente) {

        cliente.setId(idCounter);
        idCounter++;
        clientes.add(cliente);
        return cliente;


    }

    public Cliente findById(long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

        public List<Cliente> findAll() {

        return new ArrayList<Cliente>(clientes);
        }
        }
