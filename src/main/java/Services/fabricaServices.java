package Services;

import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import Models.*;
import Controllers.*;

@Path("/fabrica") 
public class fabricaServices {
	
	
	@GET
	@Path("/ListadoAutomoviles")
	@Produces({MediaType.APPLICATION_JSON})
	public Response ListadoAutomoviles() {
		
		List<Automovil> listaAuto = new ArrayList<>();
		
		listaAuto = ControllerAuto.listarAutomovil();

		return Response.ok(listaAuto).build();
		
	}
	

	@GET
	@Path("/ListadoVentas")
	@Produces({MediaType.APPLICATION_JSON})
	public Response ListadoVentas() {
		
		List<Venta> listaVentas = new ArrayList<>();
		
		listaVentas = ControllerVenta.listadoVentas();

		return Response.ok(listaVentas).build();
		
	}
	
	@POST
	@Path("/AltaAutomovil/{Modelo}/{Precio}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response AltaAutomovil(@PathParam("Modelo") String Modelo,
								  @PathParam("Precio") Double precio) {
		
		ControllerAuto ctrAuto = new ControllerAuto();
			
		ctrAuto.AltaAutomovil(new Automovil(Modelo, precio));
		
		return null;
		
	}
	
	@POST
	@Path("/EliminarAutomovil/{IdAuto}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response AltaAutomovil(@PathParam("IdAuto") Integer IdAutomovil) {
		
		ControllerAuto ctrAuto = new ControllerAuto();
			
		if(!ctrAuto.eliminarAutomovil(IdAutomovil)) {
			return Response.status(Response.Status.NOT_FOUND).entity("No existe Automovil con Id: " + IdAutomovil).build();
		};
		
		return Response.ok().build();
		
	}
	
	@POST
	@Path("/ModificarAutomovil/{IdAuto}/{Modelo}/{Precio}/")
	@Produces({MediaType.APPLICATION_JSON})
	public Response AltaAutomovil(@PathParam("IdAuto") Integer IdAutomovil,
								  @PathParam("Modelo") String Modelo,
								  @PathParam("Precio") Double precio) {
		
		ControllerAuto ctrAuto = new ControllerAuto();
			
		Automovil auto = new Automovil();
		auto.setIdAutomovil(IdAutomovil);
		auto.setModelo(Modelo);
		auto.setPrecio(precio);
		
		if(!ctrAuto.modificarAutomovil(auto)) {
			return Response.status(Response.Status.NOT_FOUND).entity("No existe Automovil con Id: " + IdAutomovil).build();
		};
		
		return Response.ok().build();
		
	}
	

}
