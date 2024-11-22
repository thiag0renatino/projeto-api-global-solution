package GlobalSolution.gs.model.bo;

import java.sql.SQLException;

import GlobalSolution.gs.model.dao.PagamentoDAO;
import GlobalSolution.gs.model.vo.Pagamento;

public class PagamentoBO {

	private static final int maxIdLength = 10;
	private static final int maxCarregamento = 90;
	
	PagamentoDAO dao = null;
	
	public boolean inserirBO(Pagamento pag) throws ClassNotFoundException, SQLException{
		
		dao = new PagamentoDAO();
		
		if(pag.getIdPagamento().length() > maxIdLength) {
			System.out.println("ERROR: ID do pagamento excede o limite de caracteres");
			return false;
		}else {
			if(pag.getTempoCarregamento() > maxCarregamento) {
				 pag.setValorPagamento(pag.getValorPagamento() + 1.00);
			}
			return dao.inserir(pag);
		}
	}
	
	public boolean deletarBO(String id) throws ClassNotFoundException, SQLException{
		
		dao = new PagamentoDAO();
		
		if(id.length() > 10) {
			System.out.println("ERROR: ID do pagamento excede o limite de caracteres");
			return false;
		}else {
			return dao.deletar(id);
		}
	}
	
	public void atualizarBO(Pagamento pag) throws ClassNotFoundException, SQLException{
		
		dao = new PagamentoDAO();
		
		if(pag.getTempoCarregamento() > maxCarregamento) {
			pag.setValorPagamento(pag.getValorPagamento() + 1.00);
		}	
		dao.atualizar(pag);
	}
	
	public Pagamento buscarBO(String id) throws ClassNotFoundException, SQLException{
		
		dao = new PagamentoDAO();
		
		return dao.buscar(id);
	}
}
