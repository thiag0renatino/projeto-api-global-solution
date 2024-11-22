package GlobalSolution.gs.model.bo;

import java.sql.SQLException;

import GlobalSolution.gs.model.dao.ClienteDAO;
import GlobalSolution.gs.model.vo.Cliente;

public class ClienteBO {

	private static final int cpfLength = 11;
	
	ClienteDAO dao = null;
	
	public boolean inserirBO(Cliente cliente) throws ClassNotFoundException, SQLException{
		
		dao = new ClienteDAO();
		
		if(cliente.getCpfClie().isEmpty() || cliente.getCpfClie().length() != cpfLength) {
			System.out.println("ERROR: CPF inválido");
			return false;
		}else {
			return dao.inserir(cliente);
		}
		

	}
	
	public boolean deletarBO(String cpfClie) throws ClassNotFoundException, SQLException{
		
		dao = new ClienteDAO();
		
		if(cpfClie.length() !=  cpfLength) {
			System.out.println("ERROR: CPF inválido");
			return false;
		}else {
			return dao.deletar(cpfClie);
		}
		
	}
	
	public void atualizarBO(Cliente cliente) throws ClassNotFoundException, SQLException{
		
		dao = new ClienteDAO();
		
		dao.atualizar(cliente);
	}
	
	public Cliente buscarBO(String cpfClie) throws ClassNotFoundException, SQLException{
		
		dao = new ClienteDAO();
		
		return dao.buscar(cpfClie);
	}
}
