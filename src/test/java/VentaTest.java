
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Controllers.ControllerOpcional;
import Controllers.ControllerVenta;
import Models.Automovil;
import Models.Opcional;
import Models.Venta;
import Models.VentaDetalle;

public class VentaTest {

	public static void main(String[] args) {

		Automovil auto = new Automovil();
		ControllerVenta vtaDAO = new ControllerVenta();
		
		Venta vta = new Venta();
		Venta vta2 = new Venta();
		Venta vta3 = new Venta();
		Opcional opc1 = new Opcional();
		Opcional opc2 = new Opcional();
		VentaDetalle vtaDetalle = new VentaDetalle();
		VentaDetalle vtaDetalle2 = new VentaDetalle();
		List<VentaDetalle> listaVtaDetalle = new ArrayList<VentaDetalle>();
		
		
		auto.setIdAutomovil(5);
		vta.setCantidad(5);
		if(!vtaDAO.realizarVenta(auto, vta, null)) {
			
			System.out.println("No se pudo realizar la venta");
		}
		

		List<Opcional> lista = new ArrayList<Opcional>();
		opc1 = ControllerOpcional.buscaOpcional(1);
		
		lista.add(opc1);
		
		vtaDetalle.setOpcionales(opc1);
		vtaDetalle.setPrecio(opc1.getPrecio());
		vtaDetalle.setVenta(vta3);
		listaVtaDetalle.add(vtaDetalle);
		
		opc2 = ControllerOpcional.buscaOpcional(2);
		
		vtaDetalle2.setOpcionales(opc2);
		vtaDetalle2.setPrecio(opc2.getPrecio());
		vtaDetalle2.setVenta(vta3);
		listaVtaDetalle.add(vtaDetalle2);

				
		auto.setIdAutomovil(3);
		vta3.setCantidad(2);
		
		
		vtaDAO.realizarVenta(auto, vta3, listaVtaDetalle);
		
		List<Venta> listadoVenta = new ArrayList<Venta>();
		
		listadoVenta = ControllerVenta.listadoVentas();
		
		for (Iterator<Venta> iterator = listadoVenta.iterator(); iterator.hasNext();) {
			
			Venta venta = (Venta) iterator.next();
			System.out.println("Venta: " + venta.getIdVenta());
			
			
		}
		
		
		

	}

}
