package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/week")
public class SemanaController {

	@Autowired
	private SemanaRepository semanaRepository;
	
	@PostMapping("/add")
	public @ResponseBody String add (int week, String user, String weekName) {
		SemanaId se = new SemanaId();
		se.setIdSemana(week);
		se.setIdUsuario(user);
		
		Semana s = new Semana(se, weekName);
		semanaRepository.save(s);
		return "Saved";
	}
	
}
