package hello;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

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
	public @ResponseBody Calendario add (String idusuario, String nombrecalendario) {
		Calendario c = new Calendario();
		CalendarioId id = new CalendarioId();
		Iterable<Calendario> list = new ArrayList<>();

		list = calendarioRepository.findAll();
		
		
		
		list.forEach((n) -> {
			if (n.getCalendarioId().getIdcalendario() >= id.getIdcalendario()) {
				id.setIdcalendario(n.getCalendarioId().getIdcalendario() +1);
			}
		});
		
		
		id.setIdusuario(idusuario);
		
		c.setCalendarioId(id);
		c.setNombrecalendario(nombrecalendario);
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
	public @ResponseBody Calendario delete (String idusuario, int idcalendario) {
		Calendario c = null;
		CalendarioId id = new CalendarioId();
		
		id.setIdcalendario(idcalendario);
		id.setIdusuario(idusuario);
		
		if (calendarioRepository.findById(id).isPresent()) {
			c = calendarioRepository.findById(id).get();
		}
		
		calendarioRepository.delete(c);
		return c;
	}
	
	@PostMapping("/edit")
	public @ResponseBody Calendario edit (@RequestBody Calendario c) {
		
		calendarioRepository.save(c);
		return c;
	}

}
