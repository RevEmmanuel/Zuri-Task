package hng.zuriinternship.tasks.service;

import hng.zuriinternship.tasks.data.dtos.requests.CreatePersonRequest;
import hng.zuriinternship.tasks.data.dtos.requests.FindPersonRequest;
import hng.zuriinternship.tasks.data.dtos.requests.UpdatePersonRequest;
import hng.zuriinternship.tasks.data.dtos.responses.PersonDto;
import java.util.List;

public interface PersonService {

    PersonDto createPerson(CreatePersonRequest createPerson);

    PersonDto findPersonByName(FindPersonRequest findPerson);

    List<PersonDto> getAllPersons();

    PersonDto updatePersonById(UpdatePersonRequest updatePersonRequest);

    String deletePersonById(Long id);

}
