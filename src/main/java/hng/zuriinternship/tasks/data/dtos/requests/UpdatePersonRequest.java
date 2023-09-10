package hng.zuriinternship.tasks.data.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdatePersonRequest {

    @NotNull(message = "Id cannot be null")
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

}
