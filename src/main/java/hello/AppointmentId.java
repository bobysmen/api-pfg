package hello;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Embeddable
public class AppointmentId implements Serializable {

	@NotNull
	private int idappointment;
	
	@NotNull
	private int idemployee;

	public int getIdappointment() {
		return idappointment;
	}

	public void setIdappointment(int idappointment) {
		this.idappointment = idappointment;
	}

	public int getIdemployee() {
		return idemployee;
	}

	public void setIdemployee(int idemployee) {
		this.idemployee = idemployee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idappointment;
		result = prime * result + idemployee;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppointmentId other = (AppointmentId) obj;
		if (idappointment != other.idappointment)
			return false;
		if (idemployee != other.idemployee)
			return false;
		return true;
	}
	
	
	
}
