package com.abc.card.credit.pojo.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class AddressDetailsDTO {
    String Address1;
    String Address2;
    String Address3;
    String city;
    String state;
    String country;
    String zipCode;
}
