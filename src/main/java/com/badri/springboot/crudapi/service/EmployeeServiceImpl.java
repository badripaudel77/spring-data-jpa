package com.badri.springboot.crudapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.badri.springboot.crudapi.dao.EmployeeRepository;
import com.badri.springboot.crudapi.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired //@Qualifier("employeeDAOJpaImpl") says use jpaimpl class
	//because we have two impl in this case ,
	//so qualifier use this and solves the problem of two beans found.
	//
	public EmployeeServiceImpl( EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	//@Transactional remove it because jparepository automatically does it.
	public List<Employee> findAll() {
	
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
	
		Optional<Employee> res = employeeRepository.findById(id);
		Employee theEmp = null;
	
		if(res.isPresent()) {
		   	theEmp = res.get();
		}
		else {
			throw new RuntimeException("couldn't find the employee" + id);
		}
		return theEmp;
	}

	@Override
	public void save(Employee emp) {
   
		employeeRepository.save(emp);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}
