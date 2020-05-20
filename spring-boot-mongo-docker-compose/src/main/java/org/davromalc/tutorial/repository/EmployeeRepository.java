package org.davromalc.tutorial.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import org.davromalc.tutorial.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
	
	public Employee findByName(String name);
	public Employee findByPlace(String placeName);
}