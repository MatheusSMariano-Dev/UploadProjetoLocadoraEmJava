package locadora.service;

import locadora.model.Filme;
import locadora.repository.FilmeRepository;
import java.util.List;

public class FilmeService {

    private FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public Filme cadastrarFilme(Filme filme) {
        if (filme.getNome() == null || filme.getNome().isEmpty()) {
            return null;
        }

        if (filme.getCategoria() == null || filme.getCategoria().isEmpty()) {
            return null;
        }
        if (filme.getValorPorHora() <= 0) {
            return null;
        }
        else {
            return filmeRepository.save(filme);
        }
    }

    public List<Filme> listarFilmes() {

        return filmeRepository.findAll();
    }

    public Filme buscarPorId(long id) {
        if (id <= 0)
            return null;
        Filme f = filmeRepository.findById(id);
        return f;

    }
}
