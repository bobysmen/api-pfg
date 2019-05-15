package hello;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Embeddable
public class SemanaId implements Serializable{
	
	@NotNull
	private int idsemana;
	
	@NotNull
	private String idusuario;
	
	public SemanaId() {
		
	}

	public SemanaId(int idsemana, String idusuario) {
		this.idsemana = idsemana;
		this.idusuario = idusuario;
	}
	
	public int getIdsemana() {
		return idsemana;
	}

	public void setIdsemana(int idsemana) {
		this.idsemana = idsemana;
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

        SemanaId that = (SemanaId) o;

        if (!(idsemana == that.idsemana)) return false;
        return idusuario.equals(that.idusuario);
    }

    @Override
    public int hashCode() {
        int result = idsemana;
        result = 31 * result + idusuario.hashCode();
        return result;
    }

}
