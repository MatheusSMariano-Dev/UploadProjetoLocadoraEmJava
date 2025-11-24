package locadora.repository;

import locadora.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeRepository {
    private long idCounter = 1;
    private List<Filme> filmes = new ArrayList<>();

    public Filme save (Filme filme) {

        filme.setId(idCounter);
        idCounter++;
        filmes.add(filme);
        return filme;


    }
    public Filme findById(long id) {

        for (Filme filme : filmes){
            if (filme.getId() == id)
                return filme;
        }
        return null;
    }



    public List<Filme> findAll() {
        return new ArrayList<Filme>(filmes);


    }
}
