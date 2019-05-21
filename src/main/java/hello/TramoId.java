package hello;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Embeddable
public class TramoId implements Serializable{
	
	@NotNull
	private String idtramo;
	
	@NotNull
	private String idusuario;
	
	@NotNull
	private int idsemana;
	
	public TramoId() {
	}

	public TramoId(String idtramo, String idusuario, int idsemana) {
		this.idtramo = idtramo;
		this.idusuario = idusuario;
		this.idsemana = idsemana;
	}
	
	public String getIdtramo() {
		return idtramo;
	}

	public void setIdtramo(String idtramo) {
		this.idtramo = idtramo;
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	
	public int getIdsemana() {
		return idsemana;
	}

	public void setIdsemana(int idsemana) {
		this.idsemana = idsemana;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TramoId that = (TramoId) o;

        if (!(idsemana == that.idsemana)) return false;
        return idusuario.equals(that.idusuario) && idtramo.equals(that.idtramo);
    }

    @Override
    public int hashCode() {
        int result = idsemana;
        result = 31 * result + idusuario.hashCode() + idtramo.hashCode();
        return result;
    }

}
