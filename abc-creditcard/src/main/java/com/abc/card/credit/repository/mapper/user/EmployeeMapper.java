package com.abc.card.credit.repository.mapper.user;

import com.abc.card.credit.pojo.rolePrivilege.PrivilegeDTO;
import com.abc.card.credit.pojo.user.EmployeeDetailDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Results(id = "employeeDetails", value = { @Result(column = "employee_id", property = "employeeId"),@Result(column = "employee_code", property = "employeeCode"),@Result(column = "name", property = "name"),
            @Result(column = "email_id", property = "emailId"),@Result(column = "PHONE_NUMBER", property = "phoneNumber")})
    @Select("SELECT employee_id,employee_code,NAME,EMAIL_ID,PHONE_NUMBER FROM TG_EMPLOYEE")
    List<EmployeeDetailDTO> getEmployee();

    @Select("SELECT employee_id,employee_code,NAME,EMAIL_ID,PHONE_NUMBER FROM TG_EMPLOYEE WHERE EMAIL_ID =#{emailId}")
    @ResultMap("employeeDetails")
    EmployeeDetailDTO getEmployeebyEmailId(@Param("emailId") String emailId);

    @Select("SELECT T4.privilege_id AS privilegeId,T4.name AS privilegeName,T4.description AS privilegeDescription " +
            " FROM TG_EMPLOYEE T1,TG_USER_ROLE T2,TG_ROLE_PRIVILEGE T3,TG_PRIVILEGE T4 WHERE T1.employee_code=#{employeeCode}" +
            " AND T1.employee_id=T2.employee_id AND T2.role_id=T3.role_id AND T4.privilege_id=T3.privilege_id")
    List<PrivilegeDTO> getPrivilegeByEmployeeCode(@Param("employeeCode") String employeeCode);

    @Update("UPDATE TG_CUSTOMER_APP_STATUS SET CONSTRAINT_CODE = #{statusCode} WHERE CUSTOMER_APP_STATUS_ID = #{appStatusId}")
    Integer updateApplicationStatus(@Param("appStatusId") Integer appStatusId,@Param("statusCode") String statusCode);

    @Insert("INSERT INTO TG_CARD_SHIPPING_DETAILS (CARD_SHIPPING_DETAILS_ID,CUSTOMER_APP_STATUS_ID,SHIPPER_NAME,TRACKING_ID,CONSTRAINT_CODE) VALUES " +
           " (9003,#{appStatusId},#{shipperName},#{trackingId},#{statusCode})")
    Integer updateApplicationTrackingDetails(@Param("appStatusId") Integer appStatusId,@Param("statusCode") String statusCode,@Param("trackingId") String trackingId,@Param("shipperName") String shipperName);
}
