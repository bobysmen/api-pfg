package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comida")

public class Comida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int idcomida;
	
	private String idusuario;
	
	private String nombrecomida;

	public int getIdcomida() {
		return idcomida;
	}

	public void setIdcomida(int idcomida) {
		this.idcomida = idcomida;
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombrecomida() {
		return nombrecomida;
	}

	public void setNombrecomida(String nombrecomida) {
		this.nombrecomida = nombrecomida;
	}
	
	
	
	

}
