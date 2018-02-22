package sv.gob.cnr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import sv.gob.cnr.entities.Producto;

public class ProductoController extends SystemController {
	
	public ProductoController(){
		
	}
	
	public void registrarProducto(Producto pro){
		transaccion.begin();
		em.persist(pro);
		transaccion.commit();
	}
	
	public List<Producto> listarProductos() throws Exception {
		List<Producto> lista = new ArrayList<Producto>();
		transaccion.begin();
		TypedQuery<Producto> listaProductos = em.createQuery("SELECT p FROM Producto p WHERE p.estado=1 ORDER BY p.id;", Producto.class);
		for(Producto p: listaProductos.getResultList()){
			lista.add(p);
		}
		transaccion.commit();
		em.close();
		return lista;
	}
}
