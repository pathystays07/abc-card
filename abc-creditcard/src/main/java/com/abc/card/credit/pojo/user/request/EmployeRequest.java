package com.abc.card.credit.pojo.user.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeRequest implements Serializable {
String name;
String emailId;
String phoneNumber;
Integer employeeId;
Integer addressId;
}
