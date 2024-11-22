package GlobalSolution.gs.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente {

	private String cpfClie;
	private String nomeClie;
	private String telClie;
	private String userClie; 
	private String senhaClie;
	
	public Cliente() {
		
	}

	public Cliente(String cpfClie, String nomeClie, String telClie, String userClie, String senhaClie) {
		this.cpfClie = cpfClie;
		this.nomeClie = nomeClie;
		this.telClie = telClie;
		this.userClie = userClie;
		this.senhaClie = senhaClie;
	}

	public String getCpfClie() {
		return cpfClie;
	}

	public void setCpfClie(String cpfClie) {
		this.cpfClie = cpfClie;
	}

	public String getNomeClie() {
		return nomeClie;
	}

	public void setNomeClie(String nomeClie) {
		this.nomeClie = nomeClie;
	}

	public String getTelClie() {
		return telClie;
	}

	public void setTelClie(String telClie) {
		this.telClie = telClie;
	}

	public String getUserClie() {
		return userClie;
	}

	public void setUserClie(String userClie) {
		this.userClie = userClie;
	}

	public String getSenhaClie() {
		return senhaClie;
	}

	public void setSenhaClie(String senhaClie) {
		this.senhaClie = senhaClie;
	}
	
	
	
}
