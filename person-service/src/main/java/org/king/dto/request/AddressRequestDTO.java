package org.king.dto.request;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class AddressRequestDTO {
    @Schema(example = "Jakarta", description = "City of address")
    private String city;

    @Schema(example = "DKI Jakarta",description = "Province of city")
    private String province;

    @Schema(example = "Cengkareng", description = "District of city")
    private String district;

    @Schema(example = "Jl. haji anjay", description = "Location of address")
    private String location;

    @Schema(example = "15769", description = "Code pos of location")
    private String codePos;

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
}
