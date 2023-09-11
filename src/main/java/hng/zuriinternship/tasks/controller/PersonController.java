package hng.zuriinternship.tasks.controller;

import hng.zuriinternship.tasks.data.dtos.requests.CreatePersonRequest;
import hng.zuriinternship.tasks.data.dtos.requests.FindPersonRequest;
import hng.zuriinternship.tasks.data.dtos.requests.UpdatePersonRequest;
import hng.zuriinternship.tasks.data.dtos.responses.PersonDto;
import hng.zuriinternship.tasks.service.PersonService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@OpenAPIDefinition
@AllArgsConstructor
@RequestMapping(value = "/api")
public class PersonController {

    private final PersonService personService;

    // Create
    @Operation(summary = "Create a new person entity",
            description = "Returns a Response entity containing the new person's details and HTTP status code.\nIt takes in a request body that contains the details required to create a new stock.")
    @PostMapping("")
    public ResponseEntity<PersonDto> createPerson(
            @RequestBody
            @Parameter(name = "CreatePersonRequest", description = "Contains the name of the person entity to be created",
                    required = true)
            @Valid CreatePersonRequest createPersonRequest) {
        return new ResponseEntity<>(personService.createPerson(createPersonRequest), HttpStatus.CREATED);
    }

    // Read
    @Operation(summary = "Get A Particular Person by the person's name",
            description = "Returns a Response entity containing the requested person and HTTP status code. If the person is not found, an exception is thrown.")
    @GetMapping("")
    public ResponseEntity<PersonDto> getPersonByName(
            @RequestParam
            @Parameter(name = "name", description = "The name of the required person",
                    required = true)
            @Valid String name) {
        return new ResponseEntity<>(personService.findPersonByName(name), HttpStatus.OK);
    }

    @Operation(summary = "Get all persons",
            description = "Returns a Response entity containing all existing persons in a List.")
    @GetMapping("/all")
    public ResponseEntity<List<PersonDto>> findAllPersons() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    // Update
    @Operation(summary = "Update the details of an existing person",
            description = "Returns a Response entity containing the updated person's details and HTTP status code.\nIt takes in the name of the stock to be updated as well as an UpdatePersonRequest containing the details to be updated in the person.")
    @PutMapping("")
    public ResponseEntity<PersonDto> updatePersonDetails(
            @RequestBody
            @Parameter(name = "UpdatePersonRequest", description = "Contains the id of the required person and the new name",
                    required = true)
            @Valid
            UpdatePersonRequest updatePersonRequest) {
        return new ResponseEntity<>(personService.updatePersonById(updatePersonRequest), HttpStatus.OK);
    }

    // Delete
    @Operation(summary = "Delete an existing person details",
            description = "Returns a Response entity HTTP status code")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(
            @PathVariable
            @Parameter(name = "id", description = "The id of the person to be deleted",
                    required = true, example = "5")
            @Valid @NotNull(message = "Id cannot be null")
            Long id) {
        return new ResponseEntity<>(personService.deletePersonById(id), HttpStatus.OK);
    }

    // Documentation
    @Operation(summary = "Get full information about the project")
    @GetMapping("/info")
    public String landingPage() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>HNGx Stage 2 Task</title>
                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            margin: 0;
                            padding: 20px;
                        }
                        h1 {
                            color: #333;
                        }
                        h2 {
                            color: #555;
                        }
                        p {
                            color: #777;
                        }
                        ul {
                            list-style-type: disc;
                            padding-left: 20px;
                        }
                        li {
                            margin-bottom: 10px;
                        }
                        a {
                            color: #007bff;
                            text-decoration: none;
                        }
                        a:hover {
                            text-decoration: underline;
                        }
                        .developer {
                            margin-top: 40px;
                            border-top: 1px solid #ccc;
                            padding-top: 20px;
                        }
                    </style>
                </head>
                <body>
                    <h1>HNGx Stage 2 Task Submission by Adeola Adekunle</h1>
                    <p>This is a Java springboot server application that handles basic CRUD operations for Person resource.</p>
                   \s
                    <h2>Features</h2>
                    <ul>
                        <li>Create Person</li>
                        <li>Find person by name</li>
                        <li>Update person details</li>
                        <li>Delete Person</li>
                    </ul>
                                
                    <h2>Extras</h2>
                    <ul>
                        <li>Find all persons</li>
                        <li>Added Landing page</li>
                        <li>No two persons can have the same name</li>
                        <li>Exception Handling</li>
                        <li>Dynamic parameter handling</li>
                    </ul>
                   \s
                   \s
                    <h2>Technologies Used</h2>
                    <ul>
                        <li>Java</li>
                        <li>Springboot</li>
                        <li>PostgreSQL</li>
                        <li>Mockito for Testing</li>
                        <li>JUnit for Testing</li>
                    </ul>
                   \s
                    <h2>Documentation</h2>
                    <p>The API documentation is available through Postman. You can access it using the following link:</p>
                    <p><a href="https://documenter.getpostman.com/view/24879226/2s9YC1XF51" target="_blank">Postman Documentation</a></p>
                    <p><a href="https://zuri-task-production.up.railway.app/swagger-ui.html" target="_blank">Swagger Documentation</a></p>
                    <p><a href="https://zuri-task-production.up.railway.app/api/info" target="_blank">Landing Page</a></p>
                   \s
                    <div class="developer">
                        <h2>Developer & Engineer</h2>
                        <p>Adeola Adekunle</p>
                        <ul>
                            <li><a href="https://github.com/RevEmmanuel" target="_blank">GitHub (RevEmmanuel)</a></li>
                            <li><a href="https://hngix.slack.com/team/U05RB8C75NY" target="_blank">Slack (Adeola Adekunle)</a></li>
                            <li><a href="https://twitter.com/Adeola_Ade1" target="_blank">Twitter (@Adeola_Ade1)</a></li>
                            <li><a href="https://www.instagram.com/deolaaxo/" target="_blank">Instagram (@deolaaxo)</a></li>
                            <li><a href="https://www.linkedin.com/in/adeola-adekunle-emmanuel/" target="_blank">LinkedIn (Adeola Adekunle)</a></li>
                            <li>Email: <a href="mailto:adeolaae1@gmail.com">adeolaae1@gmail.com</a></li>
                        </ul>
                    </div>
                </body>
                </html>
                """;
    }

}
