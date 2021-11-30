package com.abc.card.credit.repository.user;

import com.abc.card.credit.pojo.rolePrivilege.PrivilegeDTO;
import com.abc.card.credit.pojo.user.EmployeeDetailDTO;

import java.util.List;

public interface EmployeeRepository {

     List<EmployeeDetailDTO> getEmployee();
     EmployeeDetailDTO getEmployeeByEmailId(String emailId);
     List<PrivilegeDTO> getPrivilegeByEmployeeCode(String employeeCode);
     Integer updateApplicationStatus(Integer appStatusId,  String statusCode);
     Integer updateApplicationTrackingDetails(Integer appStatusId,  String trackingId,String shipperName);
}
