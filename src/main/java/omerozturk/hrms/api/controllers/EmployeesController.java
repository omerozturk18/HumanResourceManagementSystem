package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.EmployeeService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employee>> getAll(){
        return employeeService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employee employee){
        return employeeService.add(employee);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Employee employee){
        return employeeService.delete(employee);
    }

    @GetMapping("/getbyid")
    public DataResult<Optional<Employee>> getById(int employeeId){
        return employeeService.getById(employeeId);
    }
}
