package sv.gob.cnr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import sv.gob.cnr.entities.Alumno;

public class InscripcionesController extends SystemController {
	public InscripcionesController(){
		
	}
	
	public List<Alumno> listarInscripciones() throws Exception {
		List<Alumno> lista = new ArrayList<Alumno>();
		transaccion.begin();
		TypedQuery<Alumno> listaInscripciones = em.createQuery("SELECT DISTINCT a FROM Alumno a JOIN FETCH a.cursos c", Alumno.class);
		for(Alumno a: listaInscripciones.getResultList()){
			lista.add(a);
		}
		em.close();
		transaccion.commit();
		return lista;
	}
	
	
}
