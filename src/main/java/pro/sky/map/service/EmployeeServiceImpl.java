package pro.sky.map.service;

import org.springframework.stereotype.Service;
import pro.sky.map.exceptions.EmployeeAlreadyAddedException;
import pro.sky.map.exceptions.EmployeeNotFoundException;
import pro.sky.map.exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int MAX_LIST = 11;

    private final static Map<String, EmployeeBook> employeeBooks = new HashMap(Map.of(
            "Egorova",
            new EmployeeBook("Arina", "Egorova"),
            "Vasiliev",
            new EmployeeBook("Andrey", "Vasiliev"),
            "Egorov",
            new EmployeeBook("Alexandr", "Egorov"),
            "Erohin",
            new EmployeeBook("Sergey", "Erohin"),
            "Rud",
            new EmployeeBook("Irina", "Rud"),
            "Morozova",
            new EmployeeBook("Marina", "Morozova"),
            "Bogolubov",
            new EmployeeBook("Valeriy", "Bogolubov"),
            "Lavrentiev",
            new EmployeeBook("Mihail", "Lavrentiev"),
            "Pakulichev",
            new EmployeeBook("Dmitry", "Pakulichev"),
            "Simonyan",
            new EmployeeBook("Karina", "Simonyan")
    ));

    // Метод записи нового сотрудника
    @Override
    public void addEmployee(String firstName, String lastName) {
        EmployeeBook employeeBook = new EmployeeBook(firstName, lastName);
        if (employeeBooks.size() >= MAX_LIST) {
            throw new EmployeeStorageIsFullException("Нет места для записи сотрудника");
        }
        if (employeeBooks.containsValue(employeeBook)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        employeeBooks.put(employeeBook.lastName(), employeeBook);
    }

    // Метод удаления сотрудника
    @Override
    public void removeEmployee(String firstName, String lastName) {
        EmployeeBook employeeBook = new EmployeeBook(firstName, lastName);
        employeeBooks.remove(employeeBook.lastName(), employeeBook);
    }

    // Метод для поиска сотрудника
    @Override
    public EmployeeBook findEmployee(String firstName, String lastName) {
        EmployeeBook employeeBook = new EmployeeBook(firstName, lastName);
        if (!employeeBooks.containsValue(employeeBook)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employeeBook;
    }

    @Override
    public Map<String, EmployeeBook> printEmployee() {
        return employeeBooks;
    }

    @Override
    public int printSize() {
        return employeeBooks.size();

    }
}

