package hello;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="calendario")

public class Calendario {
	
	@EmbeddedId
	private CalendarioId calendarioId;
	
	private String nombrecalendario;

	public CalendarioId getCalendarioId() {
		return calendarioId;
	}

	public void setCalendarioId(CalendarioId calendarioId) {
		this.calendarioId = calendarioId;
	}

	public String getNombrecalendario() {
		return nombrecalendario;
	}

	public void setNombrecalendario(String nombrecalendario) {
		this.nombrecalendario = nombrecalendario;
	}
	
}
