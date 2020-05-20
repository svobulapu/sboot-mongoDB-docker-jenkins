package org.davromalc.tutorial.service;

import java.util.Collection;

import org.davromalc.tutorial.model.Employee;

public interface EmployeeService {

	public void createEmployee(Employee emp);

	public Collection<Employee> getAllEmployees();

	public Employee findEmployeeById(int id);
	
	public Employee findEmployeeByName(String name);
	
	public Employee findEmployeeByPlace(String placeName);

	public void deleteEmployeeById(int id);

	public void updateEmployee(Employee emp);

	public void deleteAllEmployees();
}