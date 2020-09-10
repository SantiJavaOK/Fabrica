package Controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Models.Automovil;
import Models.Opcional;
import Models.Venta;
import Models.VentaDetalle;


public class ControllerVenta {
	
	private double Total;
	private double totalDetalle;
	
	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	
	/* ------------------------------------------ */
	/* --           ALTA DE VENTAS             -- */
	/* ------------------------------------------ */
	public boolean realizarVenta(Automovil auto, Venta vta, List<VentaDetalle> vtaDet ) {
		
		emf = Persistence.createEntityManagerFactory("PersistenciaBD"); 
		manager = emf.createEntityManager();
		
		Automovil autoBD = new Automovil();
		
		/* Buscamos si existe el automovil ingresado */
		autoBD = ControllerAuto.buscaAutomovil(auto.getIdAutomovil());
		if(autoBD == null) {
			/* No se encontro el Automovil */
			return false;
		}
		
		/* Calula el precio final de la venta sumando los opcionales si es que lo tiene*/
		for (int i = 0; i < vtaDet.size(); i++) {
			/* Validar que existe el Opcionale ingresado*/
			
			totalDetalle += vtaDet.get(i).getPrecio();
		}

		Total = totalDetalle * vta.getCantidad();
		/* A la sumatoria del detalle y la venta lo multiplicamos por la cantidad de autos*/
		Total = Total + (vta.getCantidad() * autoBD.getPrecio());

		/* FIN DEL CALCULO*/
		
		vta.setModelo(auto);
		vta.setTotal(Total);
		
		manager.getTransaction().begin();
		manager.persist(vta);
		if(vtaDet != null ) {
			/* Guardamos cada linea de detalle*/
			
			for (int i = 0; i < vtaDet.size(); i++) {
				manager.persist(vtaDet.get(i));					
			}
			
		}
		
		manager.getTransaction().commit();
		manager.close();
		
		return true;
		
		
	}
	

	/* ------------------------------------------ */
	/* --        LISTADO VENTAS                -- */
	/* ------------------------------------------ */
	@SuppressWarnings("unchecked")
	public static List<Venta> listadoVentas() {
		emf = Persistence.createEntityManagerFactory("PersistenciaBD"); 
		manager = emf.createEntityManager();
		
		List<Venta> listaVentas = new ArrayList<Venta>();
		List<Venta> listaSalida = new ArrayList<Venta>();

		String queryString = "SELECT v FROM Venta v ";
		
		Query query = manager.createQuery(queryString);
		try {
		
			listaVentas = (List<Venta>) query.getResultList();
		}catch (Exception e) {
			return null;
		}
		
		for (Venta venta : listaVentas) {
			Venta vta = new Venta();
			/*Le doy formato para que me lo tome el JSON*/
			vta.setIdVenta(venta.getIdVenta());
			vta.setModelo(venta.getModelo());
			vta.setCantidad(venta.getCantidad());
			vta.setTotal(venta.getTotal());
			listaSalida.add(vta);
		}
		
		return listaSalida;
	}
	
	/* ------------------------------------------ */
	/* --        INFORM  VENTAS                -- */
	/* ------------------------------------------ */
	@SuppressWarnings("unchecked")
	public static List<Venta> informeVentas() {
		emf = Persistence.createEntityManagerFactory("PersistenciaBD"); 
		manager = emf.createEntityManager();
		
		

}
