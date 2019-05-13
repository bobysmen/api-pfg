package hello;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Embeddable
public class CalendarioId implements Serializable{
	
	@NotNull
	private int idcalendario;
	
	@NotNull
	private String idusuario;
	
	public CalendarioId() {
		
	}

	public CalendarioId(int idcalendario, String idusuario) {
		this.idcalendario = idcalendario;
		this.idusuario = idusuario;
	}

	public int getIdcalendario() {
		return idcalendario;
	}

	public void setIdcalendario(int idcalendario) {
		this.idcalendario = idcalendario;
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalendarioId that = (CalendarioId) o;

        if (!(idcalendario == that.idcalendario)) return false;
        return idusuario.equals(that.idusuario);
    }

    @Override
    public int hashCode() {
        int result = idcalendario;
        result = 31 * result + idusuario.hashCode();
        return result;
    }

}
