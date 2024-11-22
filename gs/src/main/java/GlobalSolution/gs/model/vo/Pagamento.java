package GlobalSolution.gs.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pagamento {
	
	private String idPagamento;
	private double valorPagamento;
	private String status;
	private int tempoCarregamento;
	private String idSessao;
	
	
	public Pagamento() {
		
	}


	public Pagamento(String idPagamento, double valorPagamento, String status, int tempoCarregamento, String idSessao) {
		super();
		this.idPagamento = idPagamento;
		this.valorPagamento = valorPagamento;
		this.status = status;
		this.tempoCarregamento = tempoCarregamento;
		this.idSessao = idSessao;
	}


	public String getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(String idPagamento) {
		this.idPagamento = idPagamento;
	}

	public double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIdSessao() {
		return idSessao;
	}

	public void setIdSessao(String idSessao) {
		this.idSessao = idSessao;
	}


	public int getTempoCarregamento() {
		return tempoCarregamento;
	}


	public void setTempoCarregamento(int tempoCarregamento) {
		this.tempoCarregamento = tempoCarregamento;
	}


}
