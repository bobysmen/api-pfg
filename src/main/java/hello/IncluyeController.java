package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/include")
public class IncluyeController {

	@Autowired
	private IncluyeRepository incluyeRepository;
	
	@PostMapping("/add")
	public @ResponseBody IncluyeDTO add (@RequestBody IncluyeDTO i) {
		Incluye incluye = new Incluye();
		IncluyeId id = new IncluyeId();
		
		id.setIdcomidaprincipal(i.getIdcomidaprincipal());
		id.setIdcomidasecundaria(i.getIdcomidasecundaria());
		id.setIdsemana(i.getIdsemana());
		id.setIdtramo(i.getIdtramo());
		id.setIdusuario(i.getIdusuario());
		
		incluye.setSecuencialidad(i.getSecuencialidad());
		incluye.setEscategoria(i.isEscategoria());
		incluye.setIncluyeid(id);
		
		incluyeRepository.save(incluye);
		return i;
	}
}
