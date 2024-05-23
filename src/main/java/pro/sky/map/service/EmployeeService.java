package pro.sky.map.service;

import java.util.List;

public interface EmployeeService {

    void addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    EmployeeBook findEmployee(String firstName, String lastName);

    List<EmployeeBook> printEmployee();

}
