package GlobalSolution.gs.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import GlobalSolution.gs.model.dao.SessaoCarregamentoDAO;
import GlobalSolution.gs.model.vo.SessaoCarregamento;

public class SessaoCarregamentoBO {
	
	private static final int maxIdQuiosqueLength = 10;

	SessaoCarregamentoDAO dao = null;
	
	public boolean inserirBO(SessaoCarregamento sc) throws ClassNotFoundException, SQLException{
		
		dao = new SessaoCarregamentoDAO();
		
		if(sc.getIdQuiosque().length() > maxIdQuiosqueLength) {
			System.out.println("ERROR: ID da sessão excede o limiete de caracteres");
			return false;
		}else {
			return dao.inserir(sc);
		}
	}
	
	public boolean deletarBO(String id) throws ClassNotFoundException, SQLException{
		
		dao = new SessaoCarregamentoDAO();
		
		if(id.length() > maxIdQuiosqueLength) {
			System.out.println("ERROR: ID da sessão excede o limiete de caracteres");
			return false;
		}else {
			return dao.deletar(id);
		}
	}
	
	public void atualizarBO(SessaoCarregamento sc) throws ClassNotFoundException, SQLException{
		
		dao = new SessaoCarregamentoDAO();
		
		dao.atualizar(sc);
	}
	
	public ArrayList<SessaoCarregamento> buscarTodosBO()throws ClassNotFoundException, SQLException{
		
		dao = new SessaoCarregamentoDAO();
		
		return (ArrayList<SessaoCarregamento>) dao.buscarSessoes();
	}
	
	public ArrayList<SessaoCarregamento> buscarIdQuiosqueBO(String idQuiosque)throws ClassNotFoundException, SQLException{
		
		dao = new SessaoCarregamentoDAO();
		
		return (ArrayList<SessaoCarregamento>) dao.buscarSessoesQuiosque(idQuiosque);
		
	}
}
