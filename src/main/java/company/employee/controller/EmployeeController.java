package company.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import company.employee.pojo.EmployeePojo;
import company.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping(value = "/welcome")
	public String welcomeCall() {

		return "Welcome to Company";
	}

	// public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial
	// tutorial) {

	@PostMapping(value = "/save")
	public EmployeePojo saveEmployee(@RequestBody EmployeePojo employeePojo) {

		employeePojo = employeeService.saveEmployee(employeePojo);

		return employeePojo;
	}

	@GetMapping("/get/{employeeId}")
	public EmployeePojo getEmployee(@PathVariable("employeeId") int employeeId) {

		EmployeePojo employeePojo = employeeService.getEmployee(employeeId);

		return employeePojo;
	}

	@GetMapping("/list")
	public List<EmployeePojo> listEmployee() {

		List<EmployeePojo> listEmployee = employeeService.listEmployee();

		return listEmployee;
	}

	@PostMapping(value = "/update")
	public EmployeePojo updateEmployee(@RequestBody EmployeePojo employeePojo) {

		employeeService.update(employeePojo);
		employeePojo = employeeService.getEmployee(employeePojo.getId());
		return employeePojo;
	}

	@DeleteMapping(value = "/delete/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") int employeeId) {
		employeeService.delete(employeeId);
		return "Employee deleted successfully with employee id " + employeeId;
	}

}