package org.king.utils;

import org.king.dto.response.AddressResponseDTO;
import org.king.dto.response.AddressWithPersonsResponseDTO;
import org.king.dto.response.PersonResponseDTO;
import org.king.dto.response.PersonWithAddresesResponseDTO;
import org.king.entity.Address;
import org.king.entity.Person;

public class Mapper {

    private Mapper(){}

    public static AddressWithPersonsResponseDTO addressWithPersonsResponseDTO(Address address) {
        AddressWithPersonsResponseDTO addressDTO = new AddressWithPersonsResponseDTO();
        addressDTO.setId(address.getId());
        addressDTO.setCity(address.getCity());
        addressDTO.setProvince(address.getProvince());
        addressDTO.setDistrict(address.getDistrict());
        addressDTO.setLocation(address.getLocation());
        addressDTO.setCodePos(address.getCodePos());
        addressDTO.setPersons(address.getPersons().stream().map(Mapper::personTOPersonResponseDTO)
                .toList());
        return addressDTO;
    }

    public static AddressResponseDTO addressResponseDTO(Address address) {
        AddressResponseDTO addressDTO = new AddressResponseDTO();
        addressDTO.setId(address.getId());
        addressDTO.setCity(address.getCity());
        addressDTO.setProvince(address.getProvince());
        addressDTO.setDistrict(address.getDistrict());
        addressDTO.setLocation(address.getLocation());
        addressDTO.setCodePos(address.getCodePos());
        return addressDTO;
    }


    public static PersonWithAddresesResponseDTO personWithAddresesResponseDTO(Person person) {
        PersonWithAddresesResponseDTO personDTO = new PersonWithAddresesResponseDTO();
        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setAge(person.getAge());
        personDTO.setAddreses(person.getAddresses().stream()
                .map(Mapper::addressResponseDTO)
                .toList()
        );
        return personDTO;
    }

    public static PersonResponseDTO personTOPersonResponseDTO(Person person) {
        PersonResponseDTO personDTO = new PersonResponseDTO();
        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setAge(person.getAge());
        return personDTO;
    }
}
