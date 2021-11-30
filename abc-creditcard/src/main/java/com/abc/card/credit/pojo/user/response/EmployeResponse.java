package com.abc.card.credit.pojo.user.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeResponse implements Serializable {
String name;
String emailId;
String phoneNumber;
String employeeCode;
Integer addressId;
}
