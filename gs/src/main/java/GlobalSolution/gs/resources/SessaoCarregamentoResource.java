package GlobalSolution.gs.resources;

import java.sql.SQLException;
import java.util.ArrayList;

import GlobalSolution.gs.model.bo.SessaoCarregamentoBO;
import GlobalSolution.gs.model.vo.SessaoCarregamento;
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

@Path("/sessoes")
public class SessaoCarregamentoResource {

	private SessaoCarregamentoBO sessaoCarregamentoBo = new SessaoCarregamentoBO();
	
	@POST
	@Path("/sessao")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(SessaoCarregamento sc, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		sessaoCarregamentoBo.inserirBO(sc);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(sc.getIdSessao());
		return Response.created(builder.build()).build(); 
	}
	
	@PUT
	@Path("/sessao/{idSessao}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(SessaoCarregamento sc, @PathParam("idSessao") String idSessao) throws ClassNotFoundException, SQLException {
		sessaoCarregamentoBo.atualizarBO(sc);
		return Response.ok().build();
	}
	
	
	@DELETE
	@Path("/sessao/{idSessao}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("idSessao") String idSessao) throws ClassNotFoundException, SQLException {
		sessaoCarregamentoBo.deletarBO(idSessao);
		return Response.ok().build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<SessaoCarregamento> selecionarRs() throws ClassNotFoundException, SQLException{
		return sessaoCarregamentoBo.buscarTodosBO();
	}
	
	@GET
	@Path("/{idQuiosque}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<SessaoCarregamento> selecionarRsId(@PathParam("idQuiosque") String idQuiosque) throws ClassNotFoundException, SQLException{
		return sessaoCarregamentoBo.buscarIdQuiosqueBO(idQuiosque);
	}
}
