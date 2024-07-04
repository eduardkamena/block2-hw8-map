package pro.sky.map.service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    void addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    EmployeeBook findEmployee(String firstName, String lastName);

    Map<String, EmployeeBook> printEmployee();

    int printSize();
}
