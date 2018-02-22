package sv.gob.cnr.mbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sv.gob.cnr.controller.InscripcionesController;
import sv.gob.cnr.entities.Alumno;

@ManagedBean(name="inscripcionesMB")
@ViewScoped
public class InscripcionesMB {
	private List<Alumno> lstAlumnos;


	public List<Alumno> getLstAlumnos() {
		return lstAlumnos;
	}

	public void setLstAlumnos(List<Alumno> lstAlumnos) {
		this.lstAlumnos = lstAlumnos;
	}
	
	public void listar() throws Exception {
		InscripcionesController list;
		try {
			list = new InscripcionesController();
			this.lstAlumnos = list.listarInscripciones();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
