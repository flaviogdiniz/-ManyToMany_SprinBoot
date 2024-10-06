package br.com.projeto.exemplo3.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.exemplo3.modelo.Aluno;
import br.com.projeto.exemplo3.modelo.Curso;
import br.com.projeto.exemplo3.repositorio.AlunoRepositorio;
import br.com.projeto.exemplo3.repositorio.CursoRepositorio;

@RestController
public class Controle {

   // Repositórios
   @Autowired
   private AlunoRepositorio repositorioAluno;

   @Autowired  // Adicionada a anotação @Autowired para injetar o repositorioCurso
   private CursoRepositorio repositorioCurso;
   
   // Método para cadastrar um aluno
   @PostMapping("/cadastrarAluno")
   public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
      return repositorioAluno.save(aluno);
   }
   
   // Método para cadastrar um curso
   @PostMapping("/cadastrarCurso")
   public Curso cadastrarCurso(@RequestBody Curso curso) {
      return repositorioCurso.save(curso);
   }
   
   // Método para vincular um aluno a um determinado curso
   @PostMapping("/vincular/{codigoCurso}/{codigoAluno}")
   public Aluno cadastrarAlunoCurso(@PathVariable long codigoCurso, @PathVariable long codigoAluno) {
      // Obter as informações do curso
      Curso c = repositorioCurso.findByCodigo(codigoCurso);  // Corrigido para buscar no repositorioCurso
      
      // Obter as informações do aluno
      Aluno a = repositorioAluno.findByCodigo(codigoAluno);
      
      // Adicionar o objeto de curso no atributo de cursos do aluno
      a.getCursos().add(c);
      
      // Atualizar o objeto aluno (irá cadastrar um novo curso)
      return repositorioAluno.save(a);  // Retorna o aluno atualizado
   }
}
