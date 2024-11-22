package GlobalSolution.gs.model.dao.connection;

import java.sql.Connection;
import java.sql.SQLException;

import GlobalSolution.gs.model.dao.credenciais.Credenciais;
import oracle.jdbc.pool.OracleDataSource;

public class OracleConnection {
	//Instancia do tipo singleton
	private static OracleConnection instance;
	
	//Objeto gerenciador de conexão [Abrir/Fechar] ao executar cada método
	private OracleDataSource dataSource;
	
	private OracleConnection() {
		//Configuração da instancia
		try {
			dataSource = new OracleDataSource();
			dataSource.setURL(Credenciais.url);
			dataSource.setUser(Credenciais.username);
			dataSource.setPassword(Credenciais.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new SQLException("Erro de configuracao de instancia!");
			e.printStackTrace();
		}
	}
	
	public static OracleConnection getInstance() {
		
		if (instance == null) {
			instance = new OracleConnection();
		}
		
		return instance;
	}
	
	public Connection getConnection() {
		//Retorna a conexão aberta
		try {
			
			return dataSource.getConnection();
		} catch (SQLException e) {
			
			new SQLException("Erro ao obter conexão!");
			e.printStackTrace();
			return null;
		}
		
	}

}
