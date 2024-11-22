package GlobalSolution.gs.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SessaoCarregamento {
	
	private String idSessao;
	private String tipoCarregamento;
	private String idQuiosque;
	
	public SessaoCarregamento() {
		
	}

	public SessaoCarregamento(String idSessao, String tipoCarregamento, String idQuiosque) {
		this.idSessao = idSessao;
		this.tipoCarregamento = tipoCarregamento;
		this.idQuiosque = idQuiosque;
	}

	public String getIdSessao() {
		return idSessao;
	}

	public void setIdSessao(String idSessao) {
		this.idSessao = idSessao;
	}

	public String getTipo_carregamento() {
		return tipoCarregamento;
	}

	public void setTipo_carregamento(String tipo_carregamento) {
		this.tipoCarregamento = tipo_carregamento;
	}

	public String getIdQuiosque() {
		return idQuiosque;
	}

	public void setIdQuiosque(String idQuiosque) {
		this.idQuiosque = idQuiosque;
	}
	
	
	

}
