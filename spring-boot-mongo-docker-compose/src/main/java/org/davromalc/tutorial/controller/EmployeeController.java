package org.davromalc.tutorial.controller;

import java.util.Collection;

import org.davromalc.tutorial.exception.EmployeeNotFoundException;
import org.davromalc.tutorial.model.Employee;
import org.davromalc.tutorial.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/mongo/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/divine")
	public String divineMsg() {
		return "SSVS \n SSB";
	}

	@PostMapping(value = "/add")
	public String create(@RequestBody Employee employee) {
		logger.debug("Saving employees.");
		service.createEmployee(employee);
		return "Employee with id " + employee.getId() + " created.";
	}

	@GetMapping(value = "/getall")
	public Collection<Employee> getAll() {
		logger.debug("Getting all employees.");
		return service.getAllEmployees();
	}

	@GetMapping(value = "/getbyid/{employeeId}")
	public Employee getById(@PathVariable(value = "employeeId") int id) {
		logger.debug("Getting employee with employeeId= {}.", id);
		return service.findEmployeeById(id);
	}

	@GetMapping(value = "/getbyname/{employeeName}")
	public Employee getByName(@PathVariable(value = "employeeName") String employeeName) {
		logger.debug("Getting employee with employeeName= {}.", employeeName);
		return service.findEmployeeByName(employeeName);
	}

	@GetMapping(value = "/getbyplace/{placeName}")
	public Employee getByPlace(@PathVariable(value = "placeName") String placeName) {
		logger.debug("Getting employee with employeeName= {}.", placeName);
		return service.findEmployeeByPlace(placeName);
	}

	@PutMapping(value = "/update/{employeeId}")
	public String update(@PathVariable(value = "employeeId") int id, @RequestBody Employee e) {
		logger.debug("Updating employee with employeeId= {}.", id);
		e.setId(id);
		if (service.findEmployeeById(id) == null) {
			throw new EmployeeNotFoundException("Employee id " + id + " not exists");
		}
		service.updateEmployee(e);
		return "Employee with Id " + id + " updated.";
	}

	@DeleteMapping(value = "/delete/{employeeId}")
	public String delete(@PathVariable(value = "employeeId") int id) {
		logger.debug("Deleting employee with employeeId= {}.", id);
		service.deleteEmployeeById(id);
		return "Employee with Id " + id + " deleted.";
	}

	@DeleteMapping(value = "/deleteall")
	public String deleteAll() {
		logger.debug("Deleting all employees.");
		service.deleteAllEmployees();
		return "All employee records deleted.";
	}
}