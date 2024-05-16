package pro.sky.lists.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.lists.exceptions.EmployeeAlreadyAddedException;
import pro.sky.lists.exceptions.EmployeeNotFoundException;
import pro.sky.lists.exceptions.EmployeeStorageIsFullException;
import pro.sky.lists.service.EmployeeBook;
import pro.sky.lists.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public void addEmployee(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName) {
        employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public void removeEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public EmployeeBook findEmployee(@RequestParam("firstName") String firstName,
                                     @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/print")
    public List<EmployeeBook> printEmployee() {
        return employeeService.printEmployee();
    }

    @ExceptionHandler(EmployeeStorageIsFullException.class)
    public String handlerEx() {
        return "Нет места для записи сотрудника";
    }

    @ExceptionHandler
    public String handlerEx2(EmployeeNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler
    public String handlerEx3(EmployeeAlreadyAddedException e) {
        return e.getMessage();
    }
}
