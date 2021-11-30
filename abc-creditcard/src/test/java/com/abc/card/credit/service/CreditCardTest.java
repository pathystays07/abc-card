package com.abc.card.credit.service;

import com.abc.card.CardConstant;
import com.abc.card.credit.pojo.card.credit.response.CreditCardResponse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


import spring.CardServicesConfigurationTest;

import javax.inject.Inject;
import java.util.List;

@SpringJUnitConfig(classes = {CardServicesConfigurationTest.class})
public class CreditCardTest {

    @Autowired
    CreditCardService creditCardService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void whenCreditCardAvailable(){
        List<CreditCardResponse> responseList = creditCardService.getAvailableCreditCards();
        assertNotNull(responseList);
    }
    @Test
    public void whenCreditCardEqual(){
        List<CreditCardResponse> responseList = creditCardService.getAvailableCreditCards();
       assertEquals(responseList.size(),4);
    }
    @Test
    public void whenCreditCardNotEqual(){
        List<CreditCardResponse> responseList = creditCardService.getAvailableCreditCards();
        assertNotEquals(responseList.size(),5);
    }
    @Test
    public void whenCardByTypeNotEmpty(){
        List<CreditCardResponse> responseList = creditCardService.getAvailableCardsByType(CardConstant.CREDIT_CARD_TYPE_CODE);
        assertTrue(responseList.size() > 0);
    }
    @Test
    public void whenCardByTypeEmpty(){
        List<CreditCardResponse> responseList = creditCardService.getAvailableCardsByType("234567");
        assertFalse(responseList.size() > 0);
    }
    @Test
    public void getEligibleCreditCard(){
        List<CreditCardResponse> responseList = creditCardService.getEligibleAllCreditCard();
        assertTrue(responseList.size() > 0);
    }
}
