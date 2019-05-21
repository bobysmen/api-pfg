package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/stretch")
public class TramoController {

	@Autowired
	private TramoRepository tramoRepository;

	@PostMapping("/add")
	public @ResponseBody TramoDTO add (TramoDTO tramo) {
		Tramo c = null;
		TramoId id = new TramoId();
		
		id.setIdtramo(tramo.getIdtramo());
		id.setIdusuario(tramo.getIdusuario());
		id.setIdsemana(tramo.getIdsemana());

		c = new Tramo(id, tramo.getTipotramo(), tramo.getDia());
		tramoRepository.save(c);
		return tramo;
	}


}
