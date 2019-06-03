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
@RequestMapping(path="/patient")
public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@PostMapping("/add")
	public @ResponseBody Patient add(@RequestBody Patient patient) {
		Patient pat = null;
		
		if(!patientRepository.findById(patient.getId()).isPresent()) {
			pat = patient;
			patientRepository.save(pat);
		}
		
		return pat;
	}
	
	@PostMapping("/all")
	public @ResponseBody Iterable<Patient> all () {

		Iterable<Patient> list = new ArrayList<>();
		
		list = patientRepository.findAll();
		
		return list;
}

}
