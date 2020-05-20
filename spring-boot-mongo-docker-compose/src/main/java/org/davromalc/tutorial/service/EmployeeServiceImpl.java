package org.davromalc.tutorial.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.davromalc.tutorial.model.Employee;
import org.davromalc.tutorial.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// The dao repository will use the Mongodb-Repository to perform the database operations.
	@Autowired
	EmployeeRepository repository;

	@Override
	public void createEmployee(Employee emp) {
		repository.save(emp);
	}

	@Override
	public Collection<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public Employee findEmployeeById(int id) {
		return repository.findOne(id);
	}
	
	@Override
	public Employee findEmployeeByName(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public Employee findEmployeeByPlace(String placeName) {
		return repository.findByPlace(placeName);
	}

	@Override
	public void deleteEmployeeById(int id) {
		repository.delete(id);
	}

	@Override
	public void updateEmployee(Employee emp) {
		repository.save(emp);
	}

	@Override
	public void deleteAllEmployees() {
		repository.deleteAll();
	}
}