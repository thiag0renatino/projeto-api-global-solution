package GlobalSolution.gs.resources;

import java.sql.SQLException;

import GlobalSolution.gs.model.bo.ClienteBO;
import GlobalSolution.gs.model.vo.Cliente;
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

@Path("/clientes")
public class ClienteResource {
	
	private ClienteBO clienteBO = new ClienteBO();
	
	
	@POST
	@Path("/cliente")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(Cliente cliente, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		clienteBO.inserirBO(cliente);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(cliente.getCpfClie());
		return Response.created(builder.build()).build(); 
	}
	
	@PUT
	@Path("/cliente/{cpfClie}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(Cliente cliente, @PathParam("cpfClie") String cpfClie) throws ClassNotFoundException, SQLException {
		clienteBO.atualizarBO(cliente);
		return Response.ok().build();
	}
	
	
	@DELETE
	@Path("/cliente/{cpfClie}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("cpfClie") String cpfClie) throws ClassNotFoundException, SQLException {
		clienteBO.deletarBO(cpfClie);	
		return Response.ok().build();
	}
	
	
	@GET
	@Path("/{cpfClie}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente selecionarRs(@PathParam("cpfClie") String cpfClie) throws ClassNotFoundException, SQLException{
		return clienteBO.buscarBO(cpfClie);
	}

}
