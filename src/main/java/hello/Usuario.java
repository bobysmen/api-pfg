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

	public String getNombreUsuario() {
		return nombreusuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreusuario = nombreUsuario;
	}

	public String getEmailUsuario() {
		return emailusuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailusuario = emailUsuario;
	}

	public String getContrasenaUsuario() {
		return contrasenausuario;
	}

	public void setContrasenaUsuario(String contrasenaUsuario) {
		this.contrasenausuario = contrasenaUsuario;
	}

	
    
    
}

