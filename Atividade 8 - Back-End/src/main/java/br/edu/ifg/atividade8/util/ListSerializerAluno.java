package br.edu.ifg.atividade8.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import br.edu.ifg.atividade8.entities.Aluno;

public class ListSerializerAluno extends StdSerializer<List<Aluno>>{

	private static final long serialVersionUID = 1L;

	public ListSerializerAluno() {
	        this(null);
	    }

	    public ListSerializerAluno(Class<List<Aluno>> lt) {
	        super(lt);
	    }

	    @Override
	    public void serialize(
	      List<Aluno> alunos, 
	      JsonGenerator generator, 
	      SerializerProvider provider) 
	      throws IOException, JsonProcessingException {
	        
	        List<Integer> ids = new ArrayList<>();
	        for (Aluno aluno : alunos) {
	            ids.add(aluno.getIdaluno());
	        }
	        generator.writeObject(ids);
	    }
	}