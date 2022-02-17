package tr.com.cinigaz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class MyResourceNotFoundException extends RuntimeException{
    public MyResourceNotFoundException() {
        super();
    }

    public MyResourceNotFoundException(String message) {
        super(message);
    }
}