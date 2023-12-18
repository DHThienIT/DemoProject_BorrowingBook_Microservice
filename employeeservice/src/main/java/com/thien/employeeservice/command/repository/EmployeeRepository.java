package com.thien.employeeservice.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thien.employeeservice.command.data.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
