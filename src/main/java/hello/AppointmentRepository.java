package hello;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

	public Iterable<Appointment> findAllByDate(Date dateToday);
	
}
