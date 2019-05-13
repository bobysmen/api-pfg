package hello;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/calendar")
public class CalendarioController {
	
	@Autowired
	private CalendarioRepository calendarioRepository;
	
	@PostMapping("/add")
	public @ResponseBody Calendario add (@RequestBody Calendario c) {
		
		calendarioRepository.save(c);
		return c;
	}
	
	@PostMapping("/all")
	public @ResponseBody Iterable<Calendario> add (int idcalendario, String idusuario) {

		Iterable<Calendario> list = new ArrayList<>();
		Iterator<Calendario> iterator;
		
		list = calendarioRepository.findAll();
		
		iterator = list.iterator();
		
		while (iterator.hasNext()) {
			Calendario calendar = iterator.next();
			if (!calendar.getCalendarioId().getIdusuario().equals(idusuario) || calendar.getCalendarioId().getIdcalendario() != idcalendario) {
				iterator.remove();
			}
		}
		return list;
	}
	
	@PostMapping("/delete")
	public @ResponseBody Calendario delete (@RequestBody Calendario c) {
		
		calendarioRepository.delete(c);
		return c;
	}
	
	@PostMapping("/edit")
	public @ResponseBody Calendario edit (@RequestBody Calendario c) {
		
		calendarioRepository.save(c);
		return c;
	}

}
