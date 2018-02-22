package sv.gob.cnr.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SystemController {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaDatos");
	EntityManager em = emf.createEntityManager();
	EntityTransaction transaccion = em.getTransaction();
	
	public SystemController() {
		
	}
	
	
	
	

}
