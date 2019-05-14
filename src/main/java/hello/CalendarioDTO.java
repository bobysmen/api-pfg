package hello;

public class CalendarioDTO {
	
	private int idCalendario;
    private String idUsuario;
    private String nombreCalendario;

    public CalendarioDTO(int idCalendario, String idUsuario, String nombreCalendario) {
        this.idCalendario = idCalendario;
        this.idUsuario = idUsuario;
        this.nombreCalendario = nombreCalendario;
    }

    public int getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(int idCalendario) {
        this.idCalendario = idCalendario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCalendario() {
        return nombreCalendario;
    }

    public void setNombreCalendario(String nombreCalendario) {
        this.nombreCalendario = nombreCalendario;
    }

}
