package hng.zuriinternship.tasks.service;

import hng.zuriinternship.tasks.data.dtos.responses.PersonDto;
import java.util.List;

public interface PersonService {

    PersonDto createPerson(String name);

    PersonDto findPersonByName(String personName);

    List<PersonDto> getAllPersons();

    PersonDto updatePersonByName(Long id, String updatedName);

    String deletePersonByName(Long id);

}
