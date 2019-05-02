package hello;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="semana")

public class Semana {

	@EmbeddedId
	private SemanaId semanaId;
	
	private String nombreSemana;
	
	public Semana() {
	}

	public Semana(SemanaId semanaId, String nombreSemana) {
		this.semanaId = semanaId;
		this.nombreSemana = nombreSemana;
	}

	public SemanaId getSemanaId() {
		return semanaId;
	}

	public void setSemanaId(SemanaId semanaId) {
		this.semanaId = semanaId;
	}

	public String getNombreSemana() {
		return nombreSemana;
	}

	public void setNombreSemana(String nombreSemana) {
		this.nombreSemana = nombreSemana;
	}

}
