package GlobalSolution.gs.resources;

import java.sql.SQLException;

import GlobalSolution.gs.model.bo.PagamentoBO;
import GlobalSolution.gs.model.vo.Pagamento;
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

@Path("/pagamentos")
public class PagamentoResource {
	
	private PagamentoBO pagamentoBO = new PagamentoBO();
	
	@POST
	@Path("/pagamento")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(Pagamento pagamento, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		pagamentoBO.inserirBO(pagamento);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(pagamento.getIdPagamento());
		return Response.created(builder.build()).build(); 
	}
	
	@PUT
	@Path("/pagamento/{idPagamento}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(Pagamento pagamento, @PathParam("idPagamento") String idPagamento) throws ClassNotFoundException, SQLException {
		pagamentoBO.atualizarBO(pagamento);
		return Response.ok().build();
	}
	
	
	@DELETE
	@Path("/pagamento/{idPagamento}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("idPagamento") String idPagamento) throws ClassNotFoundException, SQLException {
		pagamentoBO.deletarBO(idPagamento);
		return Response.ok().build();
	}
	
	
	@GET
	@Path("/{idPagamento}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pagamento selecionarRs(@PathParam("idPagamento") String idPagamento) throws ClassNotFoundException, SQLException{
		return pagamentoBO.buscarBO(idPagamento);
	}
	

}
