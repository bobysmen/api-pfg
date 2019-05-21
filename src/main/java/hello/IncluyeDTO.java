package hello;

public class IncluyeDTO {
	
	private String idtramo;
    private String idusuario;
    private int idsemana;
    private int secuencialidad;
    private boolean escategoria;
    private int idcomidaprincipal;
    private int idcomidasecundaria;

    public IncluyeDTO(String idtramo, String idusuario, int idsemana, int secuencialidad, boolean escategoria, int idcomidaprincipal, int idcomidasecundaria) {
        this.idtramo = idtramo;
        this.idusuario = idusuario;
        this.idsemana = idsemana;
        this.secuencialidad = secuencialidad;
        this.escategoria = escategoria;
        this.idcomidaprincipal = idcomidaprincipal;
        this.idcomidasecundaria = idcomidasecundaria;
    }

    public IncluyeDTO() {
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

    public int getIdcomidaprincipal() {
        return idcomidaprincipal;
    }

    public void setIdcomidaprincipal(int idcomidaprincipal) {
        this.idcomidaprincipal = idcomidaprincipal;
    }

    public int getIdcomidasecundaria() {
        return idcomidasecundaria;
    }

    public void setIdcomidasecundaria(int idcomidasecundaria) {
        this.idcomidasecundaria = idcomidasecundaria;
    }
}
