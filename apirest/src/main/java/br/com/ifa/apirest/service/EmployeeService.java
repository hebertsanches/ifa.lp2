package br.com.ifa.apirest.service;

import br.com.ifa.apirest.entity.Employee;
import br.com.ifa.apirest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //meotodo salvar employee serve para salvar e/ou atualizar Employee.
    public Employee salvar(Employee employee){
        return employeeRepository.save(employee);

    }

    public List<Employee> listaEmployee(){

        return employeeRepository.findAll();
    }

    public Optional<Employee> buscaPorId(Long id){

        return employeeRepository.findById(id);
    }

    public void removerPorId(Long id){
        employeeRepository.deleteById(id);
    }
}