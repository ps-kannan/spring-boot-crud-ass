package company.employee.service;

import java.util.List;

import company.employee.pojo.EmployeePojo;

public interface EmployeeService {
	
	EmployeePojo saveEmployee(EmployeePojo employeePojo);
	
	EmployeePojo getEmployee (int id);
	
	List<EmployeePojo> listEmployee ();
	
	void update (EmployeePojo employeePojo);
	
	void delete (int cusId);
}
