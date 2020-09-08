package Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Models.Automovil;

public class ControllerAuto {

	private static EntityManager manager;

	private static EntityManagerFactory emf;

	public ControllerAuto() {

	}

	/* ------------------------------------------ */
	/* ALTA AUTOMOVIL */
	/* ------------------------------------------ */
	public boolean AltaAutomovil(Automovil auto) {

		emf = Persistence.createEntityManagerFactory("PersistenciaBD");
		manager = emf.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(auto);
		manager.getTransaction().commit();

		manager.close();

		return false;

	}

	/* ------------------------------------------ */
	/* ELIMINA AUTOMOVIL */
	/* ------------------------------------------ */
	public boolean eliminarAutomovil(Integer Id) {
		emf = Persistence.createEntityManagerFactory("PersistenciaBD");
		manager = emf.createEntityManager();
		Boolean resultado = false;

		/* Buscamos el Automovil a eliminar */
		Automovil auto = new Automovil();
		auto.setIdAutomovil(Id);
		manager.getTransaction().begin();
		auto = manager.find(Automovil.class, auto.getIdAutomovil());
		if (auto != null) {
			manager.remove(auto);
			manager.getTransaction().commit();
			resultado = true;

		}

		manager.close();

		return resultado;

	}

	/* ------------------------------------------ */
	/* BUSCA AUTOMOVIL POR ID */
	/* ------------------------------------------ */
	public static Automovil buscaAutomovil(int idAutomovil) {
		emf = Persistence.createEntityManagerFactory("PersistenciaBD");
		manager = emf.createEntityManager();

		Automovil auto = new Automovil();

		String queryString = "SELECT a FROM Automovil a " + "WHERE a.IdAutomovil = :idAuto";

		Query query = manager.createQuery(queryString);
		try {
			query.setParameter("idAuto", idAutomovil);

			auto = (Automovil) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return auto;
	}

	/* ------------------------------------------ */
	/* LISTAR AUTOMOVILES */
	/* ------------------------------------------ */
	@SuppressWarnings("unchecked")
	public static List<Automovil> listarAutomovil() {
		emf = Persistence.createEntityManagerFactory("PersistenciaBD");
		manager = emf.createEntityManager();

		List<Automovil> listaAutos = new ArrayList<Automovil>();

		String queryString = "SELECT a FROM Automovil a ";

		Query query = manager.createQuery(queryString);
		try {

			listaAutos = (List<Automovil>) query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return listaAutos;
	}

	/* ------------------------------------------ */
	/* MODIFICAR AUTOMOVILES */
	/* ------------------------------------------ */
	public boolean modificarAutomovil(Automovil auto) {
		emf = Persistence.createEntityManagerFactory("PersistenciaBD");
		manager = emf.createEntityManager();

		/*Buscamos si existe el automovil a modificar*/

		manager.getTransaction().begin();
		manager.merge(auto);
		manager.getTransaction().commit();

		manager.close();


		return true;
	}

}
