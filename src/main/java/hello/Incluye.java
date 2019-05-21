package hello;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="incluye")
public class Incluye {

	@EmbeddedId
	private IncluyeId incluyeid;
	
	private int secuencialidad;
	
	private boolean escategoria;

	public Incluye(IncluyeId incluyeid, int secuencialidad, boolean escategoria) {
		this.incluyeid = incluyeid;
		this.secuencialidad = secuencialidad;
		this.escategoria = escategoria;
	}
	
	public Incluye() {
	}

	public IncluyeId getIncluyeid() {
		return incluyeid;
	}

	public void setIncluyeid(IncluyeId incluyeid) {
		this.incluyeid = incluyeid;
	}

	public int getSecuencialidad() {
		return secuencialidad;
	}

	public void setSecuencialidad(int secuencialidad) {
		this.secuencialidad = secuencialidad;
	}

	public boolean isEscategoria() {
		return escategoria;
	}

	public void setEscategoria(boolean escategoria) {
		this.escategoria = escategoria;
	}
	
	
}
