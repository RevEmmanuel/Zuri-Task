package hng.zuriinternship.tasks.exceptions;

import org.springframework.http.HttpStatus;

public class NameAlreadyExistsException extends ZuriTaskException {

    public NameAlreadyExistsException() {
        this("This name is already registered!");
    }

    public NameAlreadyExistsException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
