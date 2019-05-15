package hello;

import java.awt.List;
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
	public @ResponseBody CalendarioDTO add (String idusuario, String nombrecalendario) {
		Calendario c = new Calendario();
		CalendarioDTO cal;
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
		
		cal = new CalendarioDTO(c.getCalendarioId().getIdcalendario(), c.getCalendarioId().getIdusuario(), c.getNombrecalendario());
		return cal;
	}

	@PostMapping("/all")
	public @ResponseBody ArrayList<CalendarioDTO> all (String idusuario) {

		Iterable<Calendario> list = new ArrayList<>();
		
	    ArrayList<CalendarioDTO> listDTO = new ArrayList<>(); 
		
		list = calendarioRepository.findAll();
		
		list.forEach(calendar -> {
			if (calendar.getCalendarioId().getIdusuario().equals(idusuario)) {
				listDTO.add(new CalendarioDTO(calendar.getCalendarioId().getIdcalendario(), calendar.getCalendarioId().getIdusuario(), calendar.getNombrecalendario()));
			}
		});
		return listDTO;
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
	public @ResponseBody CalendarioDTO edit (@RequestBody CalendarioDTO c) {
		Calendario cal = new Calendario();
		CalendarioId id = new CalendarioId();
		
		id.setIdcalendario(c.getIdCalendario());
		id.setIdusuario(c.getIdUsuario());
		
		cal.setCalendarioId(id);
		cal.setNombrecalendario(c.getNombreCalendario());
		
		calendarioRepository.save(cal);
		return c;
	}

}
