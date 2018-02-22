package sv.gob.cnr.mbeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sv.gob.cnr.controller.ProductoController;
import sv.gob.cnr.entities.Producto;

@ManagedBean(name = "productoMB")
@ViewScoped
public class ProductoMB {	
	private Producto producto = new Producto();
	private List<Producto> lstProductos;

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public List<Producto> getLstProductos() {
		return lstProductos;
	}

	public void setLstProductos(List<Producto> lstProductos) {
		this.lstProductos = lstProductos;
	}

	public void registrar() throws Exception{
		ProductoController reg;
		try {
			reg = new ProductoController();
			producto.setEstado(1);
			reg.registrarProducto(producto);
		} catch (Exception e) {
			throw e;
		}
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Listo!", "El registro se almaceno correctamente"));
	}
	
	public void listar() throws Exception {
		ProductoController list;
		try {
			list = new ProductoController();
			lstProductos = list.listarProductos();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
