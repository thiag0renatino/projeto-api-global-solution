package GlobalSolution.gs.model.bo;

import java.sql.SQLException;

import GlobalSolution.gs.model.dao.DispositivoDAO;
import GlobalSolution.gs.model.vo.Dispositivo;

public class DispositivoBO {
	
	private static final int maxIdDispositivoLength = 10;
	
	DispositivoDAO dao = null;
	
	public boolean inserirBO(Dispositivo dispositivo) throws ClassNotFoundException, SQLException{
		
		dao = new DispositivoDAO();
		
		if(dispositivo.getCpfClie().length() != 11 || dispositivo.getIdDispositivo().length() > maxIdDispositivoLength ) {
			System.out.println("ERROR");
			return false;
		}else {
			return dao.inserir(dispositivo);
		}
	}
	
	public void deletarBO(String id) throws ClassNotFoundException, SQLException {
		
		dao = new DispositivoDAO();
		
		if(id.length() > maxIdDispositivoLength) {
			System.out.println("ERROR: ID do dispositivo excede o limite de caracteres");
		}else{
			dao.deletar(id);
		}
	}
	
	public void atualizarBO(Dispositivo dispositivo) throws ClassNotFoundException, SQLException{
		
		dao = new DispositivoDAO();
		
		dao.atualizar(dispositivo);
	}
	
	public Dispositivo BuscarBO(String id) throws ClassNotFoundException, SQLException{
		
		dao = new DispositivoDAO();
		
		return dao.buscar(id);
	}

}
