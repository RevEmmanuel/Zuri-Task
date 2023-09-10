package hng.zuriinternship.tasks.controller;

import hng.zuriinternship.tasks.data.dtos.responses.PersonDto;
import hng.zuriinternship.tasks.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.*;

@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePerson() throws Exception {
        String name = "Mark Essien";
        PersonDto personDto = new PersonDto(1L, name);

        when(personService.createPerson(name)).thenReturn(personDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api")
                        .param("name", name)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        verify(personService, times(1)).createPerson(name);
    }

    @Test
    public void testGetPersonByName() throws Exception {
        String name = "Mark Essien";
        PersonDto personDto = new PersonDto(1L, name);

        when(personService.findPersonByName(name)).thenReturn(personDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api")
                        .param("name", name)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        verify(personService, times(1)).findPersonByName(name);
    }

    @Test
    public void testFindAllPersons() throws Exception {
        List<PersonDto> persons = Collections.singletonList(new PersonDto(1L, "Mark Essien"));

        when(personService.getAllPersons()).thenReturn(persons);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        verify(personService, times(1)).getAllPersons();
    }

    @Test
    public void testUpdatePersonDetails() throws Exception {
        Long id = 1L;
        String updatedName = "Mark Essien Junior";
        PersonDto updatedPersonDto = new PersonDto(id, updatedName);

        when(personService.updatePersonByName(id, updatedName)).thenReturn(updatedPersonDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .put("/api")
                        .param("id", id.toString())
                        .param("name", updatedName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        verify(personService, times(1)).updatePersonByName(id, updatedName);
    }

    @Test
    public void testDeleteStock() throws Exception {
        Long id = 1L;
        String message = "Person deleted successfully";

        when(personService.deletePersonByName(id)).thenReturn(message);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api")
                        .param("id", id.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        verify(personService, times(1)).deletePersonByName(id);
    }
}
