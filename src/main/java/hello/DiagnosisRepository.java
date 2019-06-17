package hello;

import org.springframework.data.repository.CrudRepository;

public interface DiagnosisRepository extends CrudRepository<Diagnosis, Integer> {
	
	public Diagnosis findByAppointment(int appointment);

}
