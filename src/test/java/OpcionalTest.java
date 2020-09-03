import Controllers.ControllerOpcional;
import Models.Opcional;

public class OpcionalTest {

	public static void main(String[] args) {
		
		Opcional opc = new Opcional();
		
		opc.setDescripcion("Sistemas de Frenos ABS ");
		opc.setPrecio(14000.00);

		ControllerOpcional opcCtrl = new ControllerOpcional();
		
		opcCtrl.AltaOpcional(opc);
		
		
	}

}
