package hello;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	private String date;
	private int patient;
	private int employee;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPatient() {
		return patient;
	}
	public void setPatient(int patient) {
		this.patient = patient;
	}
	public int getEmployee() {
		return employee;
	}
	public void setEmployee(int employee) {
		this.employee = employee;
	}

	
	
	
	
	
}
