package hng.zuriinternship.tasks;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Zuri Stage 2 Task",
				description = "This application handles basic CRUD operations for Person resource.",
				version = "v1",
				contact = @Contact(
						name = "Adeola Adekunle",
						email = "adeolaae1@gmail.com"
				)
		),
		servers = {
				@Server(
						url = "https://zuri-task-production.up.railway.app",
						description = "PROD server"
				)
		},
		externalDocs = @ExternalDocumentation(
				url= "https://documenter.getpostman.com/view/24879226/2s9YC1XF51",
				description = "Postman Documentation"
		)
)
public class TasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
		log.info("::::::Server Running::::::");
	}

}
