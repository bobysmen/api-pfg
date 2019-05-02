package hello;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.UsuarioRepository;
import hello.Usuario;

@Controller
@RequestMapping(path="/user")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@PostMapping("/add")
	public @ResponseBody String add (String email, String password, String name) {
		
		Usuario n = new Usuario();
		n.setNombreUsuario(name);
		n.setEmailUsuario(email);
		n.setContrasenaUsuario(password);
	
		userRepository.save(n);
		return "Saved";
	}
	
	@PostMapping("/delete")
	public @ResponseBody String delete (@RequestParam String email, @RequestParam String password) {
		
		Usuario n = login(email, password);
		userRepository.delete(n);
		return "Deleted";
	}
	
	@PostMapping("/login")
	public @ResponseBody Usuario login(String email, String password) {
		Usuario u = null;
		Optional<Usuario> opt = userRepository.findById(email);
		if (opt.isPresent() && opt.get().getContrasenaUsuario().equals(password)){
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
			
			u.setNombreUsuario(name);
			u.setContrasenaUsuario(password);
			
			userRepository.save(u);
			
			response = "Updated";
		}
		
		return response;
	}
}
