package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/diagnosis")
public class DiagnosisController {

	@Autowired
	private DiagnosisRepository diagnosisRepository;
	
	@PostMapping("/getDiagnosis")
	public @ResponseBody Diagnosis getDiagnosis(int appointment) {
		Diagnosis diag = null;
		
		Diagnosis diagnosis = diagnosisRepository.findByAppointment(appointment);
		
		if(diagnosis != null) {
			diag = diagnosis;
		}
		
		return diag;
	}
	
	@PostMapping("/addDiagnosis")
	public @ResponseBody Diagnosis add(@RequestBody Diagnosis diagnosis) {
		Diagnosis diag = null;
		
		if(!diagnosisRepository.findById(diagnosis.getId()).isPresent()) {
			diag = diagnosis;
			diagnosisRepository.save(diag);
		}
		
		return diag;
	}
	
}
