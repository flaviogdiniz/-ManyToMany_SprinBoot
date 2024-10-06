package br.com.projeto.exemplo3.modelo;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cursos")
@Getter
@Setter
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    private String curso;

    @ManyToMany(mappedBy = "cursos")
    @JsonIgnore  // Ignora este campo durante a serialização
    private List<Aluno> alunos =new ArrayList<>();

}
