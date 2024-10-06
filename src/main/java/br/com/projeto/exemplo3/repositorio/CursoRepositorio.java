package br.com.projeto.exemplo3.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.exemplo3.modelo.Curso;

@Repository
public interface CursoRepositorio extends CrudRepository<Curso, Long>{
    
    // Método para buscar curso pelo código (tipo long)
    Curso findByCodigo(long codigo);
}
