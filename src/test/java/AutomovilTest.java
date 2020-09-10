import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Controllers.ControllerAuto;
import Models.Automovil;

public class AutomovilTest {

	private static EntityManager manager;

	private static EntityManagerFactory emf;
	
	public static void main(String[] args) {
		
		Automovil auto = new Automovil();
		
		auto.setModelo("Familiar");
		auto.setPrecio(275000.00);
		ControllerAuto daoAuto = new ControllerAuto();
		
		daoAuto.AltaAutomovil(auto);
		
		
		String queryString = "SELECT a FROM Automovil a " + 
				 "GROUP BY ";
		
		

	}

}
