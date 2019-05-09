package hello;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.UsuarioRepository;
import hello.Usuario;

@Controller
@RequestMapping(path="/user")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@PostMapping("/add")
	public @ResponseBody Usuario add (@RequestBody Usuario a) {
		Usuario usuario = null;
		
		if (!userRepository.findById(a.getEmailusuario()).isPresent()) {
			usuario = a;
			userRepository.save(usuario);
		}
	
		return usuario;
	}
	
	/*@PostMapping("/delete")
	public @ResponseBody String delete (@RequestParam String email, @RequestParam String password) {
		
		Usuario n = login(email, password);
		userRepository.delete(n);
		return "Deleted";
	}*/
	
	@PostMapping("/login")
	public @ResponseBody Usuario login(@RequestBody Usuario a) {
		Usuario u = null;
		Optional<Usuario> opt = userRepository.findById(a.getEmailusuario());
		if (opt.isPresent() && opt.get().getContrasenausuario().equals(a.getContrasenausuario())){
			u = opt.get();
		}
		return u;
	}
	
	@PostMapping("/update")
	public @ResponseBody String update(String email, String name, String password) {
		Usuario u = null;
		String response = "User not found";
		
		if (userRepository.findById(email).isPresent()) {
			u = userRepository.findById(email).get();
			
			u.setNombreusuario(name);
			u.setContrasenausuario(password);
			
			userRepository.save(u);
			
			response = "Updated";
		}
		
		return response;
	}
}
