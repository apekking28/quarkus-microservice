package org.king.dto.request;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class PersonRequestDTO {

    @Schema(example = "Yapek", description = "Name of person")
    private String name;
    @Schema(example = "12", description = "Age of person")
    private Integer age;

    @Schema(example = "1", description = "id of address")
    private Long addressId;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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

    public void setAge(Integer age) {
        this.age = age;
    }
}
