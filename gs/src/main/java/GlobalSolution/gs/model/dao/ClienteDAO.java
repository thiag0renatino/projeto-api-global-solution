package GlobalSolution.gs.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import GlobalSolution.gs.model.dao.connection.OracleConnection;
import GlobalSolution.gs.model.vo.Cliente;


public class ClienteDAO {

	private Connection conn;
	private OracleConnection instance;
	
	public ClienteDAO() {
		
		this.instance = OracleConnection.getInstance();

	}
	
	public boolean inserir(Cliente cliente) {
		
		String sql = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?)";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getCpfClie());
			ps.setString(2, cliente.getNomeClie());
			ps.setString(3, cliente.getTelClie());
			ps.setString(4, cliente.getUserClie());
			ps.setString(5, cliente.getSenhaClie());
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;	
	}
	
	public boolean deletar(String cpfClie) {
		
		String sql = "DELETE FROM cliente WHERE cpf_clie = ?";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cpfClie);
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;		
	}
	
	public boolean atualizar(Cliente cliente) {
		
		String sql = "UPDATE cliente SET nome_clie = ?, tel_clie = ?, user_clie = ?, senha_clie = ? "
				+ "WHERE cpf_clie = ?";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getNomeClie());
			ps.setString(2, cliente.getTelClie());
			ps.setString(3, cliente.getUserClie());
			ps.setString(4, cliente.getSenhaClie());
			ps.setString(5, cliente.getCpfClie());
			
			ps.execute();	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public Cliente buscar(String cpfClie) {
		
		String sql = "SELECT * FROM cliente WHERE cpf_clie = ?";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		Cliente clie = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cpfClie);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			clie = new Cliente();
			
			clie.setCpfClie(rs.getString("cpf_clie"));
			clie.setNomeClie(rs.getString("nome_clie"));
			clie.setTelClie(rs.getString("tel_clie"));
			clie.setUserClie(rs.getString("user_clie"));
			clie.setSenhaClie(rs.getString("senha_clie"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return clie;
	}
	
	
	
	
	
}
