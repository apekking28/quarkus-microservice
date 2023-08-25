package org.king.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.king.dto.PersonRequest;
import org.king.entity.Person;
import org.king.repository.PersonRepository;

import java.util.List;

@ApplicationScoped
public class PersonService {
    @Inject
    PersonRepository personRepository;

    @Transactional
    public Response createPerson(Person person) {
        personRepository.persist(person);
        return Response.ok(person).build();
    }

    public List<Person> getAllPeople() {
        return personRepository.listAll();
    }

    public Person getPersonById(Long id) {
        Person person = personRepository.findById(id);

        if (person == null) {
            throw new IllegalArgumentException("User with id: " + id + " not Found");
        }

        return person;
    }

    @Transactional
    public Person updatePerson(Long id, PersonRequest request) {
        Person existingPerson = getPersonById(id);

        existingPerson.setName(request.getName());
        existingPerson.setAge(request.getAge());

        return existingPerson;
    }

    @Transactional
    public String deletePersonById(Long id) {
        Person person = getPersonById(id);
        personRepository.delete(person);

        return "Successfully delete person with id : " + id;
    }

    // Other methods as needed
}
