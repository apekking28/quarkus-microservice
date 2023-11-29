package org.king.dto.response;

import java.util.List;

public class PersonWithAddresesResponseDTO {
    private Long id;

    private String name;
    private int age;

    private List<AddressResponseDTO> addreses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<AddressResponseDTO> getAddreses() {
        return addreses;
    }

    public void setAddreses(List<AddressResponseDTO> addreses) {
        this.addreses = addreses;
    }
}
