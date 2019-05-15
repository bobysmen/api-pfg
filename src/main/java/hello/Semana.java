package hello;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="semana")

public class Semana {

	@EmbeddedId
	private SemanaId semanaId;
	
	private String nombresemana;
	
	public Semana() {
	}

	public Semana(SemanaId semanaId, String nombresemana) {
		this.semanaId = semanaId;
		this.nombresemana = nombresemana;
	}

	public SemanaId getSemanaId() {
		return semanaId;
	}

	public void setSemanaId(SemanaId semanaId) {
		this.semanaId = semanaId;
	}

	public String getNombresemana() {
		return nombresemana;
	}

	public void setNombresemana(String nombresemana) {
		this.nombresemana = nombresemana;
	}

}
