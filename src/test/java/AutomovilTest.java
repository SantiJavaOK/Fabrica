import Controllers.ControllerAuto;
import Models.Automovil;

public class AutomovilTest {

	public static void main(String[] args) {
		
		Automovil auto = new Automovil();
		
		auto.setModelo("Familiar");
		auto.setPrecio(275000.00);
		ControllerAuto daoAuto = new ControllerAuto();
		
		daoAuto.AltaAutomovil(auto);
		

	}

}
