package hng.zuriinternship.tasks.data.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreatePersonRequest {

    @NotBlank(message = "Name cannot be blank")
    private String name;
}
