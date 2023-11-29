package org.king.service;

import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.king.dto.request.AddressRequestDTO;
import org.king.dto.response.AddressWithPersonsResponseDTO;
import org.king.entity.Address;
import org.king.entity.Person;
import org.king.repository.AddressRepository;
import org.king.utils.Mapper;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AddressService {

    @Inject
    AddressRepository addressRepository;

    @Transactional
    public Address createAddress(AddressRequestDTO requestDTO) {
        Address address = new Address();
        address.setCity(requestDTO.getCity());
        address.setProvince(requestDTO.getProvince());
        address.setDistrict(requestDTO.getDistrict());
        address.setLocation(requestDTO.getLocation());
        address.setCodePos(requestDTO.getCodePos());
        addressRepository.persist(address);
        return address;
    }

    public List<AddressWithPersonsResponseDTO> getAllAddress() {
        return addressRepository.listAll().stream()
                .map(Mapper::addressWithPersonsResponseDTO)
                .toList();
    }

    public AddressWithPersonsResponseDTO getAddressById(Long id) {
        Address address = addressRepository.findById(id);

        if (address == null) {
            throw new IllegalArgumentException("Address with id: " + id + " not Found");
        }

        return Mapper.addressWithPersonsResponseDTO(address);
    }

    public List<Address> getAddresses() {
        return addressRepository.listAll(Sort.ascending("city"));
    }

    @Transactional
    public String deleteAddressById(Long id) {
        Address address = addressRepository.findById(id);
        if (address != null) {
            List<Person> personList = new ArrayList<>(address.getPersons());

            for (Person person : personList) {
                person.removeAddress(address);
            }

            addressRepository.delete("id", id);
        }
        return "Successfully delete address with id : " + id;
    }

    @Transactional
    public Address updateAddressById(Long id, AddressRequestDTO requestDTO) {
        Address address = addressRepository.findById(id);

        if (address != null) {
            address.setCity(requestDTO.getCity());
            address.setProvince(requestDTO.getProvince());
            address.setDistrict(requestDTO.getDistrict());
            address.setLocation(requestDTO.getLocation());
            address.setCodePos(requestDTO.getCodePos());
        } else {
            throw new NotFoundException("Address not found with id: " + id);
        }

        return address;
    }
}

