package company.employee.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import company.employee.entity.Employee;
import company.employee.pojo.EmployeePojo;
import company.employee.repository.EmployeeRepository;

@Transactional
@Service
public class EmlpoyeeServicelmpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeePojo saveEmployee(EmployeePojo employeePojo) {
		System.out.println("Inside Save method EmployeeServiceI..mpl");

		Employee employee = new Employee();
		employee.setEmployeeName(employeePojo.getEmployeeName());
		employee.setAge(employeePojo.getAge());

		employee = employeeRepository.save(employee);

		employeePojo.setId(employee.getId());
		employeePojo.setEmployeeName(employee.getEmployeeName());
		employeePojo.setAge(employee.getAge());
		return employeePojo;

	}

	@Override
	public EmployeePojo getEmployee(int id) {
		Employee employee = employeeRepository.getById(id);

		EmployeePojo employeePojo = new EmployeePojo();
		employeePojo.setId(employee.getId());
		employeePojo.setEmployeeName(employee.getEmployeeName());
		employeePojo.setAge(employee.getAge());

		return employeePojo;
	}

	@Override
	public List<EmployeePojo> listEmployee() {
		List<EmployeePojo> employeePojoList = new ArrayList<EmployeePojo>();

		List<Employee> emp = employeeRepository.findAll();

		for (Employee employee : emp) {
			EmployeePojo employeePojo = new EmployeePojo();
			employeePojo.setId(employee.getId());
			employeePojo.setEmployeeName(employee.getEmployeeName());
			employeePojo.setAge(employee.getAge());

			employeePojoList.add(employeePojo);
		}

		return employeePojoList;
	}

	@Override
	public void update(EmployeePojo employeePojo) {
		Employee employee = employeeRepository.getById(employeePojo.getId());
		employee.setEmployeeName(employeePojo.getEmployeeName());
		employee.setAge(employeePojo.getAge());

	}

	@Override
	public void delete(int empId) {
		employeeRepository.deleteById(Integer.valueOf(empId));
	}

}
