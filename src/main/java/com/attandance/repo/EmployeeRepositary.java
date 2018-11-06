package com.attandance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attandance.domain.Employee;

@Repository
public interface EmployeeRepositary extends JpaRepository<Employee, Long>{

}
