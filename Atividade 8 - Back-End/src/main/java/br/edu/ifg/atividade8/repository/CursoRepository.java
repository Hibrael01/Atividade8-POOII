package br.edu.ifg.atividade8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifg.atividade8.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>
{
	
}