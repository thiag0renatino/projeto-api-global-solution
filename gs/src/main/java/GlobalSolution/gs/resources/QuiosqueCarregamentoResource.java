package GlobalSolution.gs.resources;

import java.sql.SQLException;
import java.util.ArrayList;

import GlobalSolution.gs.model.bo.QuiosqueCarregamentoBO;
import GlobalSolution.gs.model.vo.QuiosqueCarregamento;
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

@Path("/quiosques")
public class QuiosqueCarregamentoResource {

	private QuiosqueCarregamentoBO quiosqueCarregamentoBO = new QuiosqueCarregamentoBO();
	
	@POST
	@Path("/quiosque")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(QuiosqueCarregamento qc, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		quiosqueCarregamentoBO.inserirBO(qc);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(qc.getId_quiosque());
		return Response.created(builder.build()).build(); 
	}
	
	@PUT
	@Path("/quiosque/{idQuiosque}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(QuiosqueCarregamento qc, @PathParam("idQuiosque") String idQuiosque) throws ClassNotFoundException, SQLException {
		quiosqueCarregamentoBO.atualizarBO(qc);
		return Response.ok().build();
	}
	
	
	@DELETE
	@Path("/quiosque/{idQuiosque}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("idQuiosque") String idQuiosque) throws ClassNotFoundException, SQLException {
		quiosqueCarregamentoBO.deletarBO(idQuiosque);
		return Response.ok().build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<QuiosqueCarregamento> selecionarRs() throws ClassNotFoundException, SQLException{
		return quiosqueCarregamentoBO.buscarTodosBO();
	}
	
	@GET
	@Path("/{idQuiosque}")
	@Produces(MediaType.APPLICATION_JSON)
	public QuiosqueCarregamento selecionarRS(@PathParam("idQuiosque") String idQuiosque) throws ClassNotFoundException, SQLException{
		return quiosqueCarregamentoBO.buscarBO(idQuiosque);
	}

	
	
}
