package hello;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tramo")

public class Tramo {
	
	@EmbeddedId
	private TramoId tramoid;
	
    private String tipotramo;
    
    private String dia;

    public Tramo(TramoId tramoid, String tipotramo, String dia) {
    	this.tramoid = tramoid;
        this.tipotramo = tipotramo;
        this.dia = dia;
    }
    
    public Tramo() {
    }

    public TramoId getTramoid() {
		return tramoid;
	}

	public void setTramoid(TramoId tramoid) {
		this.tramoid = tramoid;
	}

	public String getTipotramo() {
        return tipotramo;
    }

    public void setTipotramo(String tipotramo) {
        this.tipotramo = tipotramo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
