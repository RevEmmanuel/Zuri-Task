package hng.zuriinternship.tasks.service;

import hng.zuriinternship.tasks.data.dtos.requests.CreatePersonRequest;
import hng.zuriinternship.tasks.data.dtos.requests.UpdatePersonRequest;
import hng.zuriinternship.tasks.data.dtos.responses.PersonDto;
import hng.zuriinternship.tasks.data.models.Person;
import hng.zuriinternship.tasks.data.repository.PersonRepository;
import hng.zuriinternship.tasks.exceptions.NameAlreadyExistsException;
import hng.zuriinternship.tasks.exceptions.PersonNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Override
    public PersonDto createPerson(CreatePersonRequest createPersonRequest) {
        if (personRepository.existsByName(createPersonRequest.getName())) throw new NameAlreadyExistsException("A user with this name already exists!");
        Person createdPerson = Person.builder()
                .name(createPersonRequest.getName())
                .build();
        Person savedPerson = personRepository.save(createdPerson);
        return mapPersonToDto(savedPerson);
    }

    @Override
    public PersonDto findPersonByName(String name) {
        Person foundPerson = personRepository.findByName(name).orElseThrow(() -> new PersonNotFoundException("Person with name " + name + " not found!"));
        return mapPersonToDto(foundPerson);
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> allPersons = personRepository.findAll();
        return allPersons.stream()
                .map(PersonServiceImpl::mapPersonToDto)
                .toList();
    }

    @Override
    public PersonDto updatePersonById(UpdatePersonRequest updatePersonRequest) {
        Person personToBeUpdated = personRepository.findById(updatePersonRequest.getId()).orElseThrow(() -> new PersonNotFoundException("Person with id " + updatePersonRequest.getId() + " not found!"));
        personToBeUpdated.setName(updatePersonRequest.getName());
        Person updatedPerson = personRepository.save(personToBeUpdated);
        return mapPersonToDto(updatedPerson);
    }

    @Override
    public String deletePersonById(Long id) {
        Person personToBeDeleted = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person with id " + id + " not found!"));
        personRepository.delete(personToBeDeleted);
        return "SUCCESSFUL";
    }

    private static PersonDto mapPersonToDto(Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .name(person.getName())
                .build();
    }

}
