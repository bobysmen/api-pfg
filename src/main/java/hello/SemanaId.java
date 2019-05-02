package hello;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Embeddable
public class SemanaId implements Serializable{
	
	@NotNull
	private int idSemana;
	
	@NotNull
	private String idUsuario;
	
	public SemanaId() {
		
	}

	public SemanaId(int idSemana, String idUsuario) {
		this.idSemana = idSemana;
		this.idUsuario = idUsuario;
	}

	public int getIdSemana() {
		return idSemana;
	}

	public void setIdSemana(int idSemana) {
		this.idSemana = idSemana;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SemanaId that = (SemanaId) o;

        if (!(idSemana == that.idSemana)) return false;
        return idUsuario.equals(that.idUsuario);
    }

    @Override
    public int hashCode() {
        int result = idSemana;
        result = 31 * result + idUsuario.hashCode();
        return result;
    }

}
