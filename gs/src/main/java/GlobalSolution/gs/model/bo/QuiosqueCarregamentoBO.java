package GlobalSolution.gs.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import GlobalSolution.gs.model.dao.QuiosqueCarregamentoDAO;
import GlobalSolution.gs.model.vo.QuiosqueCarregamento;

public class QuiosqueCarregamentoBO {
	
	private static final int maxIdLength = 10;
	
	QuiosqueCarregamentoDAO dao = null;
	
	
	public boolean inserirBO(QuiosqueCarregamento qc) throws ClassNotFoundException, SQLException{
		
		dao = new QuiosqueCarregamentoDAO();
		
		if(qc.getId_quiosque().length() > maxIdLength) {
			System.out.println("ERROR: ID do quiosque de carregamento excede o limite de caracteres");
			return false;
		}else {
			return dao.inserir(qc);
		}
	}
	
	public boolean deletarBO(String id) throws ClassNotFoundException, SQLException{
		
		dao = new QuiosqueCarregamentoDAO();
		
		if(id.length() > maxIdLength) {
			System.out.println("ERROR: ID do quiosque de carregamento excede o limite de caracteres");
			return false;
		}else {
			return dao.deletar(id);
		}
		
	}
	
	public void atualizarBO(QuiosqueCarregamento qc)throws ClassNotFoundException, SQLException{
		
		dao = new QuiosqueCarregamentoDAO();
		
		dao.atualizar(qc);
	}
	
	public ArrayList<QuiosqueCarregamento> buscarTodosBO() throws ClassNotFoundException, SQLException{
		
		dao = new QuiosqueCarregamentoDAO();
		
		return (ArrayList<QuiosqueCarregamento>) dao.buscarQuiosques();
	}
	
	public QuiosqueCarregamento buscarBO(String id)throws ClassNotFoundException, SQLException{
		
		dao = new QuiosqueCarregamentoDAO();
		
		return dao.buscar(id);
	}
	
	

}
