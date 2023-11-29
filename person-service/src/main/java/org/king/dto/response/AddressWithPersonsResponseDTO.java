package org.king.dto.response;

import java.util.List;

public class AddressWithPersonsResponseDTO {

    private Long id;
    private String city;
    private String province;
    private String district;
    private String location;

    private String codePos;

    private List<PersonResponseDTO> persons;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCodePos() {
        return codePos;
    }

    public void setCodePos(String codePos) {
        this.codePos = codePos;
    }

    public List<PersonResponseDTO> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonResponseDTO> persons) {
        this.persons = persons;
    }
}
