package com.abc.card.credit.pojo.user.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerRequest implements Serializable {
    String Name;
    String Id;
    String code;
    String phoneNumber;
    Integer age;
    String emailId;
    String qualification;
    double salary;
    String company;
    Number yearsOfExperience;
    List<AddressRequest> addressRequestList;
}
