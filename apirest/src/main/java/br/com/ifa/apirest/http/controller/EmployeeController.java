package br.com.ifa.apirest.http.controller;

import br.com.ifa.apirest.entity.Employee;
import br.com.ifa.apirest.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/employee", method = RequestMethod.POST) //determinando a rota do employee
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee salvar(@RequestBody Employee employee){
        return employeeService.salvar(employee);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> listaEmployee(){
        return employeeService.listaEmployee();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee buscaEmployeePorId(@PathVariable("id") Long id){
        return employeeService.buscaPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empregado não Encontrado"));

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEmployee(@PathVariable("id") Long id){
        employeeService.buscaPorId(id)
                .map(employee -> {
                    employeeService.removerPorId(employee.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empregado não encontrado"));
    }
    //Metodo para atualizacao do empregado

   @PutMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void salvarEmployee(@PathVariable("id") Long id,@RequestBody Employee employee){
       employeeService.buscaPorId(id)
               .map(employeeBase -> {
                   modelMapper.map(employee, employeeBase);
                   employeeService.salvar(employeeBase);
                   return Void.TYPE;
               }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empregado não encontrado"));
   }

}
