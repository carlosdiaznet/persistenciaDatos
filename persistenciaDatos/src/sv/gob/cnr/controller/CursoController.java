package sv.gob.cnr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import sv.gob.cnr.entities.Curso;

public class CursoController extends SystemController {

	public CursoController() {
		
	}
	
	public void registrarCurso(Curso curso){
		transaccion.begin();
		em.persist(curso);
		transaccion.commit();
	}
	
	public List<Curso> listarCursos() throws Exception {
		List<Curso> lista = new ArrayList<Curso>();
		transaccion.begin();
		TypedQuery<Curso> listaCursos = em.createQuery("SELECT c FROM Curso c WHERE c.estado=1 ORDER BY c.id;", Curso.class);
		for(Curso c: listaCursos.getResultList()){
			
			lista.add(c);
		}
		em.close();
		transaccion.commit();
		
		return lista;
	}
	
	

}
