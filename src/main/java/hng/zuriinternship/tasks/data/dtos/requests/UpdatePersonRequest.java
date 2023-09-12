package hng.zuriinternship.tasks.data.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UpdatePersonRequest {

    @NotBlank(message = "Name cannot be blank")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Invalid characters. Only alphabets and spaces are allowed!")
    private String name;

}
