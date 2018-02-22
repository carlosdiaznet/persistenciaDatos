package sv.gob.cnr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import sv.gob.cnr.entities.Alumno;

public class AlumnoController extends SystemController {
	
	public AlumnoController() {
		
	}

	public void registrarAlumno(Alumno aln){
		transaccion.begin();
		em.persist(aln);
		transaccion.commit();
	}
	
	public List<Alumno> listarAlumnos() throws Exception {
		List<Alumno> lista = new ArrayList<Alumno>();
		transaccion.begin();
		TypedQuery<Alumno> listaAlumnos = em.createQuery("SELECT a FROM Alumno a WHERE a.estado=1 ORDER BY a.id;", Alumno.class);
		
		for(Alumno a: listaAlumnos.getResultList()){
			lista.add(a);
		}
		em.close();
		transaccion.commit();
		return lista;
		
	}
	/*
	public TypedQuery<Alumno> listarAlumnos2() throws Exception {
		transaccion.begin();
		TypedQuery<Alumno> listaAlumnos = em.createQuery("SELECT a FROM Alumno a WHERE a.estado=1 ORDER BY a.id;", Alumno.class);
		transaccion.commit();
		em.close();
		return listaAlumnos;
	}*/
	
	public Alumno alumnoID(Alumno alm) throws Exception {

		transaccion.begin();
		Alumno almn = em.find(Alumno.class, alm.getId());
		transaccion.commit();
		em.close();
		
		return almn;
	}
	
	public void modificar(Alumno alm) throws Exception {
		try {
			transaccion.begin();
			em.merge(alm);
			transaccion.commit();
			em.close();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void eliminar(Alumno alm) throws Exception {
		try {
			transaccion.begin();
			alm.setEstado(0);
			em.merge(alm);
			transaccion.commit();
			em.close();
		} catch (Exception e) {
			throw e;
		}
	}
}
