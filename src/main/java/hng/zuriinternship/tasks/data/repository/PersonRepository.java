package hng.zuriinternship.tasks.data.repository;

import hng.zuriinternship.tasks.data.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    boolean existsByNameEqualsIgnoreCase(String name);

    Optional<Person> findByName(String name);

    Optional<Person> findByNameEqualsIgnoreCase(String name);

}
