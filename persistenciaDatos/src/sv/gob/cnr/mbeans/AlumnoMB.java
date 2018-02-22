package sv.gob.cnr.mbeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import sv.gob.cnr.controller.AlumnoController;
import sv.gob.cnr.entities.Alumno;

@ManagedBean(name = "alumnoMB")
@ViewScoped
public class AlumnoMB {
	private Alumno alumno = new Alumno();
	private List<Alumno> lstAlumnos;

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public List<Alumno> getLstAlumnos() {
		return lstAlumnos;
	}

	public void setLstAlumnos(List<Alumno> lstAlumnos) {
		this.lstAlumnos = lstAlumnos;
	}
	

	public void registrar() throws Exception {
		AlumnoController reg;
		try {
			reg = new AlumnoController();
			alumno.setEstado(1);
			reg.registrarAlumno(alumno);
		} catch (Exception e) {
			throw e;
		}
	//	FacesContext context = FacesContext.getCurrentInstance();
	//	context.addMessage(null, new FacesMessage("Listo!", "Los datos del alumno se almacenaron correctamente"));
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Almacenado con exito");
        FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void listar() throws Exception {
		AlumnoController list;
		try {
			list = new AlumnoController();
			lstAlumnos = list.listarAlumnos();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void alumnoID(Alumno alm) throws Exception{
		AlumnoController var;
		try {
			var = new AlumnoController();
			this.alumno = var.alumnoID(alm);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	
	public void modificar() throws Exception {
		AlumnoController var = new AlumnoController();
		try {
			var.modificar(alumno);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void eliminar(Alumno alm) throws Exception {
		AlumnoController var = new AlumnoController();
		try {
			var.eliminar(alm);
		} catch (Exception e) {
			throw e;
		}
	}

}
