package hello;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

	public Iterable<Appointment> findAllByDate(String dateToday);
	public Iterable<Appointment> findAllByPatient(int patient);
	
}
