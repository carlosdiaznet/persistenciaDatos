package sv.gob.cnr.mbeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sv.gob.cnr.controller.CursoController;
import sv.gob.cnr.entities.Curso;

@ManagedBean(name ="cursoMB")
@ViewScoped
public class CursoMB {
	Curso curso = new Curso();
	
	private List<Curso> lstCursos;

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	
	public List<Curso> getLstCursos() {
		return lstCursos;
	}

	public void setLstCursos(List<Curso> lstCursos) {
		this.lstCursos = lstCursos;
	}

	public void registrar() throws Exception {
		CursoController reg;
		try {
			reg = new CursoController();
			curso.setEstado(1);
			reg.registrarCurso(curso);
		} catch (Exception e) {
			throw e;
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Listo!", "Los datos del curso se almacenaron correctamente"));
	}
	
	public void listar() throws Exception {
		CursoController list;
		try {
			list = new CursoController();
			lstCursos = list.listarCursos();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
