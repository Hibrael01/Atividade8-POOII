package br.edu.ifg.atividade8.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifg.atividade8.entities.Aluno;
import br.edu.ifg.atividade8.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> findAll(){
		return repository.findAll();
	}
	
	public Aluno findById(Integer id) {
		return repository.findById(id).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND)  );
	}
	
	public Aluno insert(Aluno a) {
		return repository.save(a);
	}
	
	public void delete (Integer id) {
			repository.findById(id).map(
				aluno -> {
							repository.delete(aluno);
							return Void.TYPE;
						 }).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND)  );		
	}
	
	public Aluno update (Integer id, Aluno a) {
		return repository.findById(id).map(
					aluno -> { 
								aluno.setNome( a.getNome() ); 
								aluno.setSexo( a.getSexo() ); 
								aluno.setDt_nasc( a.getDt_nasc());
							    return repository.save(aluno);
							 }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
	}
	
}