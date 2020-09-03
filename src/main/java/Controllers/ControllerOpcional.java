package Controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Models.Automovil;
import Models.Opcional;

public class ControllerOpcional {
	
	private static EntityManager manager;

	private static EntityManagerFactory emf;
	
	public ControllerOpcional() {
		
	}
	
	/* ------------------------------------------  */
	/* ALTA AUTOMOVIL */
	/* ------------------------------------------  */
	public boolean AltaOpcional(Opcional opcional) {
		
		emf = Persistence.createEntityManagerFactory("PersistenciaBD"); 
		manager = emf.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(opcional);
		manager.getTransaction().commit();
		
		manager.close();
		
		return false;
		
	}
	
	/* ------------------------------------------  */
	/* BUSCA OPCIONAL POR ID */
	/* ------------------------------------------  */
	public static Opcional buscaOpcional(int idOpcional) {
		emf = Persistence.createEntityManagerFactory("PersistenciaBD"); 
		manager = emf.createEntityManager();
		
		Opcional opc = new Opcional();

		String queryString = "SELECT o FROM Opcional o " + 
							 "WHERE o.IdOpcional = :idOpcion";
		
		Query query = manager.createQuery(queryString);
		try {
		query.setParameter("idOpcion", idOpcional);
		
		opc = (Opcional) query.getSingleResult();
		}catch (Exception e) {
			return null;
		}
		return opc;
	}

}
