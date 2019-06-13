package hello;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public @ResponseBody Iterable<Appointment> allTodayAppointment (String dateToday, int id_employee) {
		
		Iterable<Appointment> listAux = new ArrayList<>();
		List<Appointment> listFinal = new ArrayList<>();
		
		listAux = appointmentRepository.findAllByDate(dateToday);
		
		for(Appointment a : listAux ){
			if(a.getId_employee() == id_employee) {
				listFinal.add(a);
			}
		}
		
		return listFinal;
	}
	
	@PostMapping("/add")
	public @ResponseBody Appointment add (@RequestBody Appointment appointment) {
		Appointment a = null;
		
		if(!appointmentRepository.findById(appointment.getId()).isPresent()) {
			a = appointment;
			appointmentRepository.save(a);
		}
		
		return a;
	}
	
}
