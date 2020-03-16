package com.badri.springboot.crudapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.badri.springboot.crudapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//no code to write , as we got a lot of methods for free.
}
