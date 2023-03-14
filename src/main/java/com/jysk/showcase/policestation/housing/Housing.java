package com.jysk.showcase.policestation.housing;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.stereotype.Component;

@JsonTypeInfo(
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "housingType",
        use = JsonTypeInfo.Id.NAME,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Apartment.class, name = "APARTMENT"),
})
@Component
public abstract class Housing {
    private String Insurance;
    private Integer NumberOfResidents;
    private HousingType HousingType;

    public Housing(String insurance, Integer numberOfResidents, com.jysk.showcase.policestation.housing.HousingType housingType) {
        Insurance = insurance;
        NumberOfResidents = numberOfResidents;
        HousingType = housingType;
    }

    public String getInsurance() {
        return Insurance;
    }

    public void setInsurance(String insurance) {
        Insurance = insurance;
    }

    public Integer getNumberOfResidents() {
        return NumberOfResidents;
    }

    public void setNumberOfResidents(Integer numberOfResidents) {
        NumberOfResidents = numberOfResidents;
    }

    public com.jysk.showcase.policestation.housing.HousingType getHousingType() {
        return HousingType;
    }

    public void setHousingType(com.jysk.showcase.policestation.housing.HousingType housingType) {
        HousingType = housingType;
    }
}
