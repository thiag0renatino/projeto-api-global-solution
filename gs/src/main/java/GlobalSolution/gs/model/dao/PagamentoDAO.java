package GlobalSolution.gs.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import GlobalSolution.gs.model.dao.connection.OracleConnection;
import GlobalSolution.gs.model.vo.Pagamento;

public class PagamentoDAO {
	
	private Connection conn;
	
	private OracleConnection instance;

	public PagamentoDAO() {
		
		this.instance = OracleConnection.getInstance();
	}
	
	public boolean inserir (Pagamento pagamento) {
		
		String sql = "INSERT INTO pagamento VALUES (?, ?, ?, ?, ?)";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pagamento.getIdPagamento());
			ps.setDouble(2, pagamento.getValorPagamento());
			ps.setString(3, pagamento.getStatus());
			ps.setInt(4, pagamento.getTempoCarregamento());
			ps.setString(5, pagamento.getIdSessao());
			
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
		
		String sql = "DELETE FROM pagamento WHERE id_pagamento = ?";
		
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
	
	public boolean atualizar(Pagamento pagamento) {
		
		String sql = "UPDATE pagamento SET valor_pagamento = ?, status = ?, id_sessao = ?, tempo_carregamento = ? WHERE id_pagamento = ?";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, pagamento.getValorPagamento());
			ps.setString(2, pagamento.getStatus());
			ps.setString(3, pagamento.getIdSessao());
			ps.setInt(4, pagamento.getTempoCarregamento());
			ps.setString(5, pagamento.getIdPagamento());
			
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
	
	public Pagamento buscar(String id) {
		
		String sql = "SELECT * FROM pagamento WHERE id_pagamento = ?";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		Pagamento p = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			p = new Pagamento();
			
			p.setIdPagamento(rs.getString("id_pagamento"));
			p.setValorPagamento(rs.getDouble("valor_pagamento"));
			p.setStatus(rs.getString("status"));
			p.setTempoCarregamento(rs.getInt("tempo_carregamento"));
			p.setIdSessao(rs.getString("id_sessao"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	

}
