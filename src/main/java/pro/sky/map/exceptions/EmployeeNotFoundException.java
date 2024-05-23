package pro.sky.map.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Сотрудник не найден")
public class EmployeeNotFoundException extends UnsupportedOperationException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
