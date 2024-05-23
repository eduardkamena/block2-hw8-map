package pro.sky.map.service;

import org.springframework.stereotype.Service;
import pro.sky.map.exceptions.EmployeeAlreadyAddedException;
import pro.sky.map.exceptions.EmployeeNotFoundException;
import pro.sky.map.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int MAX_LIST = 11;

    private final static List<EmployeeBook> employeeBooks = new ArrayList<>(Arrays.asList(
            new EmployeeBook("Arina", "Egorova"),
            new EmployeeBook("Andrey", "Vasiliev"),
            new EmployeeBook("Alexandr", "Egorov"),
            new EmployeeBook("Sergey", "Erohin"),
            new EmployeeBook("Irina", "Rud"),
            new EmployeeBook("Marina", "Morozova"),
            new EmployeeBook("Valeriy", "Bogolubov"),
            new EmployeeBook("Mihail", "Lavrentiev"),
            new EmployeeBook("Dmitry", "Pakulichev"),
            new EmployeeBook("Karina", "Simoniyan")
    ));

    // Метод записи нового сотрудника
    @Override
    public void addEmployee(String firstName, String lastName) {
        EmployeeBook employeeBook = new EmployeeBook(firstName, lastName);
        if (employeeBooks.size() >= MAX_LIST) {
            throw new EmployeeStorageIsFullException("Нет места для записи сотрудника");
        }
        if (employeeBooks.contains(employeeBook)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        employeeBooks.add(employeeBook);
    }

    // Метод удаления сотрудника
    @Override
    public void removeEmployee(String firstName, String lastName) {
        EmployeeBook employeeBook = new EmployeeBook(firstName, lastName);
        employeeBooks.remove(employeeBook);
    }

    // Метод для поиска сотрудника
    @Override
    public EmployeeBook findEmployee(String firstName, String lastName) {
        EmployeeBook employeeBook = new EmployeeBook(firstName, lastName);
        if (!employeeBooks.contains(employeeBook)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employeeBook;
    }

    @Override
    public List<EmployeeBook> printEmployee() {
        return employeeBooks;
    }

}

