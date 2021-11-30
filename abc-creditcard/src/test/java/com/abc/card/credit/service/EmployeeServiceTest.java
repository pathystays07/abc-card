package com.abc.card.credit.service;


import com.abc.card.credit.pojo.card.credit.response.CustomerCardDetailResponse;
import com.abc.card.credit.pojo.user.response.EmployeResponse;
import com.abc.card.credit.service.user.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import spring.CardServicesConfigurationTest;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {CardServicesConfigurationTest.class})
public class EmployeeServiceTest {

    final String  emailId="test@test.com";
    final String applicationId = "7001";

    @Inject
    EmployeeService employeeService;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllEmployeeDetails(){
        List<EmployeResponse> employeResponseList= employeeService.getEmployee();
        assertNotNull(employeResponseList);
    }
    @Test
    public void whenUserHasAccessToFetchCardDetails() throws Exception {
        CustomerCardDetailResponse customerCardDetailResponse= employeeService.getCardApplicationByStatusId(emailId,applicationId);
        assertNotNull(customerCardDetailResponse);
    }
    @Test
    public void whenUserDoesNotAccessToFetchCardDetails(){
        assertThrows(Exception.class, () ->{
            CustomerCardDetailResponse customerCardDetailResponse= employeeService.getCardApplicationByStatusId("hendry@test.com",applicationId);
        });
    }
    @Test
    public void whenUserDoesNotAccessToApproveCardDetails(){
        assertThrows(Exception.class, () ->{
            CustomerCardDetailResponse customerCardDetailResponse= employeeService.getCardApplicationByStatusId("paul@1test.com",applicationId);
        });
    }

    @Test
    public void whenApplicationIdIsInvalid() throws Exception {
            CustomerCardDetailResponse customerCardDetailResponse= employeeService.getCardApplicationByStatusId(emailId,"34567");
            assertNull(customerCardDetailResponse.getCardName());

    }
    @Test
    public void whenUserDoesNotHaveAccessUpdatedApplicationSucess(){
        assertThrows(Exception.class, () ->{
            Map<String,Boolean> responseMap = employeeService.approveOrRejectCard("paul@test.com",applicationId,"APP_004");
        });
    }
    @Test
    public void whenApplicationStatusUpdatedSucess() throws Exception {
        Map<String,Boolean> responseMap = employeeService.approveOrRejectCard(emailId,applicationId,"APP_004");
        assertEquals(responseMap.get("status"),true);
    }

}
