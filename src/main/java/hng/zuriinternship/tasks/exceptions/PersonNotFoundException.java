package hng.zuriinternship.tasks.exceptions;
import org.springframework.http.HttpStatus;

public class PersonNotFoundException extends ZuriTaskException {

    public PersonNotFoundException() {
        this("Not Found");
    }

    public PersonNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}

