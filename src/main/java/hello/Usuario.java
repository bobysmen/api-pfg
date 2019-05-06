package hello;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="usuario")

public class Usuario {
	
    @Id
    private String emailusuario;
    
    private String nombreusuario;
    
    private String contrasenausuario;

	public String getNombreusuario() {
		return nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public String getEmailusuario() {
		return emailusuario;
	}

	public void setEmailusuario(String emailusuario) {
		this.emailusuario = emailusuario;
	}

	public String getContrasenausuario() {
		return contrasenausuario;
	}

	public void setContrasenausuario(String contrasenausuario) {
		this.contrasenausuario = contrasenausuario;
	}

	
    
    
}

