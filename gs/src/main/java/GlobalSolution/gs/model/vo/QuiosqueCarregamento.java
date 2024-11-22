package GlobalSolution.gs.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class QuiosqueCarregamento {

	private String idQuiosque;
	private int qntSessoesCarregamento;
	private String statusQuiosque;
	private String qrCode;
	
	public QuiosqueCarregamento() {
		
	}

	public QuiosqueCarregamento(String idQuiosque, int qntSessoesCarregamento, String statusQuiosque, String qrCode) {
		this.idQuiosque = idQuiosque;
		this.qntSessoesCarregamento = qntSessoesCarregamento;
		this.statusQuiosque = statusQuiosque;
		this.qrCode = qrCode;
	}

	public String getId_quiosque() {
		return idQuiosque;
	}

	public void setId_quiosque(String id_quiosque) {
		this.idQuiosque = id_quiosque;
	}

	public int getQntSessoesCarregamento() {
		return qntSessoesCarregamento;
	}

	public void setQntSessoesCarregamento(int qntSessoesCarregamento) {
		this.qntSessoesCarregamento = qntSessoesCarregamento;
	}

	public String getStatusQuiosque() {
		return statusQuiosque;
	}

	public void setStatusQuiosque(String statusQuiosque) {
		this.statusQuiosque = statusQuiosque;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	
	
	
	
}
