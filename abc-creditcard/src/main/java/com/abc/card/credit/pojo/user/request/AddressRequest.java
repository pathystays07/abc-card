package com.abc.card.credit.pojo.user.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressRequest implements Serializable {
    String Address1;
    String Address2;
    String Address3;
    String city;
    String state;
    String country;
    String zipCode;
}
