package com.abc.card.credit.repository.mapper.user;

import com.abc.card.credit.pojo.card.credit.CustomerCardDetailDTO;
import com.abc.card.credit.pojo.user.CustomerDetailsDTO;
import com.abc.card.credit.pojo.user.EmployeeDetailDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerMapper {

    @Results(id = "customerDetails", value = { @Result(column = "CUSTOMER_ID", property = "id"),@Result(column = "CUSTOMER_CODE", property = "code"),@Result(column = "name", property = "name"),
            @Result(column = "email_id", property = "emailId"),@Result(column = "PHONE_NUMBER", property = "phoneNumber")})
    @Select("SELECT CUSTOMER_ID,CUSTOMER_CODE,NAME,EMAIL_ID,PHONE_NUMBER FROM TG_CUSTOMER")
    List<CustomerDetailsDTO> getCustomer();

    @Select("SELECT COUNT(1) FROM TG_CUSTOMER WHERE email_id = #{emailId}")
    Integer getCustomerByEmailId(@Param("emailId") String emailId);

    @Select({"<script> SELECT T3.CARD_NAME AS NAME,T2.COMMENTS,T4.CONSTRAINT_CODE AS applicationStatusCode," +
            "T4.CONSTRAINT_VALUE AS applicationStatusValue,T4.CONSTRAINT_DESC AS applicationStatusDesc FROM TG_CUSTOMER T1," +
            "TG_CUSTOMER_APP_STATUS T2,TG_CARD T3,TG_CARD_CONSTANTS T4 WHERE " +
            "<if  test = '#{emailId} != null'> T1.EMAIL_ID= #{emailId} AND  </if> " +
            " <if  test = '#{applicationStatus} != null'>  T2.CONSTRAINT_CODE=#{applicationStatus} AND </if> T1.CUSTOMER_ID=T2.CUSTOMER_ID" +
            " AND T2.CARD_ID=T3.CARD_ID AND T2.CONSTRAINT_CODE=T4.CONSTRAINT_CODE </script>"})
    List<CustomerCardDetailDTO> getCustomerCreditCardByEmailIdOrStatusOrBoth(@Param("emailId") String emailId, @Param("applicationStatus")String applicationStatus);

    @Select({"<script> SELECT T1.NAME,T1.email_id AS emailId,T3.CARD_NAME AS NAME,T2.COMMENTS,T4.CONSTRAINT_CODE AS applicationStatusCode," +
            "T4.CONSTRAINT_VALUE AS applicationStatusValue,T4.CONSTRAINT_DESC AS applicationStatusDesc FROM TG_CUSTOMER T1," +
            "TG_CUSTOMER_APP_STATUS T2,TG_CARD T3,TG_CARD_CONSTANTS T4 WHERE " +
            "<if  test = '#{emailId} != null'> T1.EMAIL_ID= #{emailId} AND  </if> " +
            " <if  test = '#{applicationStatus} != null'>  T2.CONSTRAINT_CODE=#{applicationStatus} AND </if> T1.CUSTOMER_ID=T2.CUSTOMER_ID" +
            " AND T2.CARD_ID=T3.CARD_ID AND T2.CONSTRAINT_CODE=T4.CONSTRAINT_CODE </script>" })
    List<CustomerCardDetailDTO> fetchCustomerCreditCardByEmailIdOrStatusOrBoth(@Param("emailId") String emailId, @Param("applicationStatus")String applicationStatus);

    @Select(" SELECT T1.NAME,T1.email_id AS emailId,T3.CARD_NAME AS NAME,T2.COMMENTS,T4.CONSTRAINT_CODE AS applicationStatusCode," +
            "T4.CONSTRAINT_VALUE AS applicationStatusValue,T4.CONSTRAINT_DESC AS applicationStatusDesc FROM TG_CUSTOMER T1," +
            "TG_CUSTOMER_APP_STATUS T2,TG_CARD T3,TG_CARD_CONSTANTS T4 WHERE " +
            "  T2.CUSTOMER_APP_STATUS_ID=#{appStatusId} AND  T1.CUSTOMER_ID=T2.CUSTOMER_ID" +
            " AND T2.CARD_ID=T3.CARD_ID AND T2.CONSTRAINT_CODE=T4.CONSTRAINT_CODE")
    CustomerCardDetailDTO fetchCustomerCreditCardByStatusId( @Param("appStatusId")String appStatusId);
}
