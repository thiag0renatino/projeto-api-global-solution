package GlobalSolution.gs.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dispositivo {
	
	private String idDispositivo;
	private String marcaDispositivo;
	private String modeloDispositivo;
	private String cpfClie;
	
	public Dispositivo() {
		
	}

	public Dispositivo(String idDispositivo, String marcaDispositivo, String modeloDispositivo, String cpfClie) {
		this.idDispositivo = idDispositivo;
		this.marcaDispositivo = marcaDispositivo;
		this.modeloDispositivo = modeloDispositivo;
		this.cpfClie = cpfClie;
	}

	public String getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(String idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public String getMarcaDispositivo() {
		return marcaDispositivo;
	}

	public void setMarcaDispositivo(String marcaDispositivo) {
		this.marcaDispositivo = marcaDispositivo;
	}

	public String getModeloDispositivo() {
		return modeloDispositivo;
	}

	public void setModeloDispositivo(String modeloDispositivo) {
		this.modeloDispositivo = modeloDispositivo;
	}

	public String getCpfClie() {
		return cpfClie;
	}

	public void setCpfClie(String cpfClie) {
		this.cpfClie = cpfClie;
	}
	

}
