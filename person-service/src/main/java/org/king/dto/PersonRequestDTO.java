package org.king.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class PersonRequestDTO {

    @Schema(example = "Yapek", description = "Name of person")
    private String name;
    @Schema(example = "12", description = "Age of person")
    private int age;

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
}
