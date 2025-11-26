
package locadora.repository;

import locadora.model.Aluguel;
import java.util.ArrayList;
import java.util.List;

public class AluguelRepository {
    private final List<Aluguel> banco = new ArrayList<>();

    public Aluguel findById(long id) {
        for (Aluguel a : banco) {
            if (a.getId() == id) return a;
        }
        return null;
    }

    public void salvar(Aluguel aluguel) {
        if (findById(aluguel.getId()) == null) {
            banco.add(aluguel);
        } else {
            atualizar(aluguel);
        }
    }

    public void atualizar(Aluguel aluguel) {
        for (int i = 0; i < banco.size(); i++) {
            if (banco.get(i).getId() == aluguel.getId()) {
                banco.set(i, aluguel);
                return;
            }
        }
        banco.add(aluguel);
    }

    public List<Aluguel> listarTodos() {
        return new ArrayList<>(banco);
    }
}
