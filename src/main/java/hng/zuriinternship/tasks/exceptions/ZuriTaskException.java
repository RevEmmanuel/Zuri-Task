package hng.zuriinternship.tasks.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ZuriTaskException extends RuntimeException {

    @Getter
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public ZuriTaskException(){
        this("Error Processing Request!");
    }

    public ZuriTaskException(String message){
        super(message);
    }

    public ZuriTaskException(String message, HttpStatus status) {
        this(message);
        this.status = status;
    }

}
