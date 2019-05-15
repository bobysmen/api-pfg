package hello;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/week")
public class SemanaController {

	@Autowired
	private SemanaRepository semanaRepository;
	
	@PostMapping("/add")
	public @ResponseBody SemanaDTO add (String idusuario, String nombresemana) {
		Semana c = new Semana();
		SemanaDTO cal;
		SemanaId id = new SemanaId();
		Iterable<Semana> list = new ArrayList<>();

		list = semanaRepository.findAll();
		
		
		
		list.forEach((n) -> {
			if (n.getSemanaId().getIdsemana() >= id.getIdsemana()) {
				id.setIdsemana(n.getSemanaId().getIdsemana() +1);
			}
		});
		
		
		id.setIdusuario(idusuario);
		
		c.setSemanaId(id);
		c.setNombresemana(nombresemana);
		semanaRepository.save(c);
		
		cal = new SemanaDTO(c.getSemanaId().getIdsemana(), c.getSemanaId().getIdusuario(), c.getNombresemana());
		return cal;
	}

	@PostMapping("/all")
	public @ResponseBody ArrayList<SemanaDTO> all (String idusuario) {

		Iterable<Semana> list = new ArrayList<>();
		
	    ArrayList<SemanaDTO> listDTO = new ArrayList<>(); 
		
		list = semanaRepository.findAll();
		
		list.forEach(week -> {
			if (week.getSemanaId().getIdusuario().equals(idusuario)) {
				listDTO.add(new SemanaDTO(week.getSemanaId().getIdsemana(), week.getSemanaId().getIdusuario(), week.getNombresemana()));
			}
		});
		return listDTO;
	}
	
	@PostMapping("/delete")
	public @ResponseBody Semana delete (String idusuario, int idcalendario) {
		Semana c = null;
		SemanaId id = new SemanaId();
		
		id.setIdsemana(idcalendario);
		id.setIdusuario(idusuario);
		
		if (semanaRepository.findById(id).isPresent()) {
			c = semanaRepository.findById(id).get();
		}
		
		semanaRepository.delete(c);
		return c;
	}
	
	@PostMapping("/edit")
	public @ResponseBody SemanaDTO edit (@RequestBody SemanaDTO c) {
		Semana cal = new Semana();
		SemanaId id = new SemanaId();
		
		id.setIdsemana(c.getIdsemana());
		id.setIdusuario(c.getIdUsuario());
		
		cal.setSemanaId(id);
		cal.setNombresemana(c.getNombreSemana());
		
		semanaRepository.save(cal);
		return c;
	}
	
}
