package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/patient")
public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository;

}
