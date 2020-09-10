package Services;

import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import Models.*;
import Controllers.*;

@Path("")
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
	
	@PUT
	@Path("/AltaAutomovil")
	@Produces({MediaType.APPLICATION_JSON})
	public Response AltaAutomovil(Automovil Auto) {
		
		ControllerAuto ctrAuto = new ControllerAuto();
			
		ctrAuto.AltaAutomovil(Auto);
		
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
	@Path("/ModificarAutomovil")
	@Produces({MediaType.APPLICATION_JSON})
	public Response ModificarAutomovil(Automovil Auto) {
		
		ControllerAuto ctrAuto = new ControllerAuto();
		
		
		if(!ctrAuto.modificarAutomovil(Auto)) {
			return Response.status(Response.Status.NOT_FOUND).entity("No existe Automovil con Id: " + Auto.getIdAutomovil()).build();
		};
		
		return Response.ok().build();
		
	}
	

}
