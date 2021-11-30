package com.abc.card.credit.service;

import static org.junit.jupiter.api.Assertions.*;

import com.abc.card.credit.service.user.CustomerService;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import spring.CardServicesConfigurationTest;

import javax.inject.Inject;
import java.util.Map;

@SpringJUnitConfig(classes = {CardServicesConfigurationTest.class})
public class CustomerServiceTest {
    @Inject
    CustomerService customerService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void withValidCustomerEmailId(){
        Map<String,Boolean> response= customerService.validateCustomerByEmailId("test@gtest.com");
        System.out.println(response);
        assertTrue(response.get("status"));

    }
    @Test
    public void withInValidCustomerEmailId(){
        Map<String,Boolean> response= customerService.validateCustomerByEmailId("test@gtest1.com");
        assertFalse(response.get("status"));
    }
}
