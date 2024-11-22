package GlobalSolution.gs.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import GlobalSolution.gs.model.dao.connection.OracleConnection;
import GlobalSolution.gs.model.vo.SessaoCarregamento;

public class SessaoCarregamentoDAO {

	private Connection conn;
	
	private OracleConnection instance;

	public SessaoCarregamentoDAO() {
		this.instance = OracleConnection.getInstance();
	}
	
	public boolean inserir(SessaoCarregamento sc) {
		
		String sql = "INSERT INTO sessao_carregamento VALUES (?, ?, ?)";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sc.getIdSessao());
			ps.setString(2, sc.getTipo_carregamento());
			ps.setString(3, sc.getIdQuiosque());
			
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
	
	public boolean deletar(String id) {
		
		String sql = "DELETE FROM sessao_carregamento WHERE id_sessao = ?";
		
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
	
	public boolean atualizar(SessaoCarregamento sc) {
		
		String sql = "UPDATE sessao_carregamento SET tipo_carregamento = ?, id_quiosque = ? WHERE id_sessao = ?";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sc.getTipo_carregamento());
			ps.setString(2, sc.getIdQuiosque());
			ps.setString(3, sc.getIdSessao());
			
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
	
	public List<SessaoCarregamento> buscarSessoes(){
		
		List<SessaoCarregamento> sessoes = new ArrayList<SessaoCarregamento>();
		
		String sql = "SELECT * FROM sessao_carregamento";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
				
		try {
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				sessoes.add(new SessaoCarregamento(
						rs.getString("id_sessao"),
						rs.getString("tipo_carregamento"),
						rs.getString("id_quiosque")));
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
		return sessoes;
	}
	
	public List<SessaoCarregamento> buscarSessoesQuiosque(String idQuiosque){
		
		List<SessaoCarregamento> sessoes = new ArrayList<SessaoCarregamento>();
		
		String sql = "SELECT * FROM sessao_carregamento WHERE id_quiosque = ?";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idQuiosque);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				sessoes.add(new SessaoCarregamento(
						rs.getString("id_sessao"),
						rs.getString("tipo_carregamento"),
						rs.getString("id_quiosque")));
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
		return sessoes;
				
	}
	
}
