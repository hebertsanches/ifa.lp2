package br.com.ifa.apirest.repository;

import br.com.ifa.apirest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//Interface EmployeeRepository através do JPArepository conseguira fazer o CRUD do Employee
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}