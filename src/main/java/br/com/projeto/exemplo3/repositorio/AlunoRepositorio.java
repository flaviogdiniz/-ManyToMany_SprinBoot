package br.com.projeto.exemplo3.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.exemplo3.modelo.Aluno;

@Repository
public interface AlunoRepositorio extends CrudRepository<Aluno, Long> {

    // Método para buscar aluno pelo código
    Aluno findByCodigo(long codigo);
    
} 