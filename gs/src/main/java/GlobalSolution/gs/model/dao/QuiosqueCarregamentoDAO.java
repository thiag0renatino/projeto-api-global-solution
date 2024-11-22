package GlobalSolution.gs.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import GlobalSolution.gs.model.dao.connection.OracleConnection;
import GlobalSolution.gs.model.vo.QuiosqueCarregamento;

public class QuiosqueCarregamentoDAO {
	
	private Connection conn;
	private OracleConnection instance;
	
	public QuiosqueCarregamentoDAO() {
		this.instance = OracleConnection.getInstance();
	}
	
	public boolean inserir(QuiosqueCarregamento qc) {
		
		String sql = "INSERT INTO quiosque_carregamento VALUES (?, ?, ?, ?)";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, qc.getId_quiosque());
			ps.setInt(2, qc.getQntSessoesCarregamento());
			ps.setString(3, qc.getStatusQuiosque());
			ps.setString(4, qc.getQrCode());
			
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
	
	public boolean deletar (String id) {
		
		String sql = "DELETE FROM quiosque_carregamento WHERE id_quiosque= ?";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
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
	
	public boolean atualizar (QuiosqueCarregamento qc) {
		
		String sql = "UPDATE quiosque_carregamento SET qnt_sessoes_carregamento = ?, status_quiosque = ?, qr_code = ? "
				+ "WHERE id_quiosque = ?";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, qc.getQntSessoesCarregamento());
			ps.setString(2, qc.getStatusQuiosque());
			ps.setString(3, qc.getQrCode());
			ps.setString(4, qc.getId_quiosque());
			
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
	
	public QuiosqueCarregamento buscar(String id) {
		
		String sql = "SELECT * FROM quiosque_carregamento WHERE id_quiosque = ?";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		QuiosqueCarregamento qc = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			qc = new QuiosqueCarregamento();
			qc.setId_quiosque(rs.getString("id_quiosque"));
			qc.setQntSessoesCarregamento(rs.getInt("qnt_sessoes_carregamento"));
			qc.setStatusQuiosque(rs.getString("status_quiosque"));
			qc.setQrCode(rs.getString("qr_code"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return qc;
	}
	
	public List<QuiosqueCarregamento> buscarQuiosques(){
		
		List<QuiosqueCarregamento> quiosques = new ArrayList<QuiosqueCarregamento>();
		
		String sql = "SELECT * FROM quiosque_carregamento";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				quiosques.add(new QuiosqueCarregamento(
						rs.getString("id_quiosque"),
						rs.getInt("qnt_sessoes_carregamento"),
						rs.getString("status_quiosque"),
						rs.getString("qr_code")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return quiosques;
	}
	
	

}
