package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/add")
	public @ResponseBody Employee add(@RequestBody Employee employee) {
		Employee emp = null;
		
		if(!employeeRepository.findById(employee.getId()).isPresent()) {
			emp = employee;
			employeeRepository.save(emp);
		}
		
		return emp;
	}
	
	@PostMapping("/login")
	public @ResponseBody Employee login(String email, String password) {
		Employee emp = null;
		
		Employee employee = employeeRepository.findByEmail(email);
		
		if(employee != null && employee.getPassword().equals(password)) {
			emp  = employee;
		}
		
		return emp;
	}

}
