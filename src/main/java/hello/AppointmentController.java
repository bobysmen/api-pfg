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
	public @ResponseBody Iterable<Appointment> allTodayAppointment (String date, int employee) {
		
		Iterable<Appointment> listAux = new ArrayList<>();
		List<Appointment> listFinal = new ArrayList<>();
		String onlyDate;
		
		String [] dateSplitToday = date.split(" ");
		
		onlyDate = dateSplitToday[0];
		
		listAux = appointmentRepository.findAllByEmployee(employee);
		
		for(Appointment a : listAux ){
			String [] dateSplit = a.getDate().split(" ");
			if(dateSplit[0].equals(onlyDate)) {
				listFinal.add(a);
			}
		}
		
		return listFinal;
	}
	
	@PostMapping("/perDay")
	public @ResponseBody Iterable<Appointment> allPerDayAppointment (String date, int employee) {
		
		Iterable<Appointment> listAux = new ArrayList<>();
		List<Appointment> listFinal = new ArrayList<>();
		
		listAux = appointmentRepository.findAllByEmployee(employee);
		
		for(Appointment a : listAux ){
			String [] dateSplit = a.getDate().split(" ");
			if(dateSplit[0].equals(date)) {
				listFinal.add(a);
			}
		}
		
		return listFinal;
	}
	
	@PostMapping("/allPerPatient")
	public @ResponseBody Iterable<Appointment> allPerPatient (int patient) {
		
		Iterable<Appointment> listAux = new ArrayList<>();
		List<Appointment> listFinal = new ArrayList<>();
		
		listAux = appointmentRepository.findAllByPatient(patient);
		
		for(Appointment a : listAux ){
			if(a.getPatient() == patient) {
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
