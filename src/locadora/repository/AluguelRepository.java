package locadora.repository;

import locadora.model.Aluguel;
import java.util.ArrayList;
import java.util.List;

public class AluguelRepository {

    private List<Aluguel> alugueis = new ArrayList<>();
    private long idCounter = 1;

    public Aluguel save(Aluguel aluguel) {
        aluguel.setId(idCounter);
        idCounter++;
        alugueis.add(aluguel);
        return aluguel;
    }

    public Aluguel findById(long id) {
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getId() == id) {
                return aluguel;
            }
        }
        return null;
    }

    public List<Aluguel> findAll() {
        return new ArrayList<>(alugueis);
    }
}
