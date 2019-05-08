package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/food")
public class ComidaController {
	
	@Autowired
	private ComidaRepository comidaRepository;
	
	@PostMapping("/add")
	public @ResponseBody String add (@RequestBody Comida c) {
		
		
		comidaRepository.save(c);
		return "Saved";
	}

}
