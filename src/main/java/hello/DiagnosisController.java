package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/diagnosis")
public class DiagnosisController {

	@Autowired
	private DiagnosisRepository diagnosisRepository;
	
}
