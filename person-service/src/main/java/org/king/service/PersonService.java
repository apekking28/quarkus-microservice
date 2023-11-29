package org.king.service;


import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.king.dto.request.PersonRequestDTO;
import org.king.dto.response.PersonWithAddresesResponseDTO;
import org.king.entity.Address;
import org.king.entity.Person;
import org.king.repository.AddressRepository;
import org.king.repository.PersonRepository;
import org.king.utils.Mapper;

import java.util.List;

@ApplicationScoped
public class PersonService {
    @Inject
    PersonRepository personRepository;

    @Inject
    AddressRepository addressRepository;

    @Transactional
    public Person createPerson(PersonRequestDTO personRequestDTO) {
        Address address = addressRepository.findById(personRequestDTO.getAddressId());

        Person person = new Person();
        person.setName(personRequestDTO.getName());
        person.setAge(personRequestDTO.getAge());
        person.setAddresses(List.of(address));
        personRepository.persist(person);
        return person;
    }

    public List<PersonWithAddresesResponseDTO> getAllPeople() {
        return personRepository.listAll()
                .stream().map(Mapper::personWithAddresesResponseDTO).toList();
    }

    public PersonWithAddresesResponseDTO getPersonById(Long id) {
        Person person = personRepository.findById(id);
        if (person == null) {
            throw new IllegalArgumentException("User with id: " + id + " not Found");
        }
        return Mapper.personWithAddresesResponseDTO(person);
    }

    @Transactional
    public Person updatePerson(Long id, PersonRequestDTO request) {
        Person person = personRepository.findById(id);
        if (person == null) {
            throw new IllegalArgumentException("User with id: " + id + " not Found");
        }
        person.setName(request.getName());
        person.setAge(request.getAge());
        return person;
    }

    @Transactional
    public String deletePersonById(Long id) {
        Person person = personRepository.findById(id);

        if (person == null) {
            throw new IllegalArgumentException("User with id: " + id + " not Found");
        }

        personRepository.delete(person);
        return "Successfully delete person with id : " + id;
    }

    public List<Person> getPeoples() {
        return personRepository.listAll(Sort.ascending("name", "id"));
    }
}
