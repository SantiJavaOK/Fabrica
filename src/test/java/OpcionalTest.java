import Controllers.ControllerOpcional;
import Models.Opcional;

public class OpcionalTest {

	public static void main(String[] args) {
		
		Opcional opc = new Opcional();
		
		opc.setDescripcion("Llantas de aleación");
		opc.setPrecio(12000.00);
		opc.setAlias("LL");

		ControllerOpcional opcCtrl = new ControllerOpcional();
		
		opcCtrl.AltaOpcional(opc);
		
		
	}

}
