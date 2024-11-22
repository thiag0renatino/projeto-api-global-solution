package GlobalSolution.gs.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import GlobalSolution.gs.model.dao.connection.OracleConnection;
import GlobalSolution.gs.model.vo.Dispositivo;

public class DispositivoDAO {
	
	private Connection conn;
	private OracleConnection instance;
	
	public DispositivoDAO() {
		
		this.instance = OracleConnection.getInstance();
	}
	
	public boolean inserir (Dispositivo dispositivo) {
		
		String sql = "INSERT INTO dispositivo VALUES (?,?,?,?)";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dispositivo.getIdDispositivo());
			ps.setString(2, dispositivo.getMarcaDispositivo());
			ps.setString(3, dispositivo.getModeloDispositivo());
			ps.setString(4, dispositivo.getCpfClie());
			
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
	
	public boolean deletar (String idDispositivo) {
		
		String sql = "DELETE FROM dispositivo WHERE id_dispositivo = ?";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idDispositivo);
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public boolean atualizar(Dispositivo ds) {
		
		String sql = "UPDATE dispositivo SET marca_dispositivo = ?, modelo_dispoitivo = ?, cliente_cpf_clie = ? WHERE id_dispositivo = ?";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ds.getMarcaDispositivo());
			ps.setString(2, ds.getModeloDispositivo());
			ps.setString(3, ds.getCpfClie());
			ps.setString(4, ds.getIdDispositivo());
			
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
	
	public Dispositivo buscar (String idDispositivo) {
		
		String sql = "SELECT * FROM dispositivo WHERE id_dispositivo = ?";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		Dispositivo ds = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idDispositivo);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			ds = new Dispositivo();
			
			ds.setIdDispositivo(rs.getString("id_dispositivo"));
			ds.setMarcaDispositivo(rs.getString("marca_dispositivo"));
			ds.setModeloDispositivo(rs.getString("modelo_dispoitivo"));
			ds.setCpfClie(rs.getString("cliente_cpf_clie"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ds;
	}
	

}
