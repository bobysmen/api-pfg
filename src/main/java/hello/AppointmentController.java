package hello;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/appointment")
public class AppointmentController {

	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	
	@PostMapping("/today")
	public @ResponseBody Iterable<Appointment>add(Date dateToday) {
		
		Iterable<Appointment> list = new ArrayList<>();
		
		list = appointmentRepository.findAllByDate(dateToday);
		
		return list;
	}
	
}
