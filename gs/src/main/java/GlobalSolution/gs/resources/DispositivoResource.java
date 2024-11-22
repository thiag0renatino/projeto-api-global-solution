package GlobalSolution.gs.resources;

import java.sql.SQLException;

import GlobalSolution.gs.model.bo.DispositivoBO;
import GlobalSolution.gs.model.vo.Dispositivo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/dispositivos")
public class DispositivoResource {

	private DispositivoBO dispositivoBO = new DispositivoBO();
	
	@POST
	@Path("/dispositivo")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(Dispositivo dispositivo, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		dispositivoBO.inserirBO(dispositivo);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(dispositivo.getIdDispositivo());
		return Response.created(builder.build()).build(); 
	}
	
	@PUT
	@Path("/dispositivo/{idDispositivo}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(Dispositivo dispositivo, @PathParam("idDispositivo") String idDispositivo) throws ClassNotFoundException, SQLException {
		dispositivoBO.atualizarBO(dispositivo);
		return Response.ok().build();
	}
	
	
	@DELETE
	@Path("/dispositivo/{idDispositivo}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("idDispositivo") String idDispositivo) throws ClassNotFoundException, SQLException {
		dispositivoBO.deletarBO(idDispositivo);
		return Response.ok().build();
	}
	
	
	@GET
	@Path("/{idDispositivo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Dispositivo selecionarRs(@PathParam("idDispositivo") String idDispositivo) throws ClassNotFoundException, SQLException{
		return dispositivoBO.BuscarBO(idDispositivo);
	}
	
}
