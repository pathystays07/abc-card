package com.abc.card.credit.service;

import static org.mockito.Mockito.*;

import com.abc.card.credit.pojo.card.credit.CardDetailDTO;
import com.abc.card.credit.pojo.card.credit.response.CreditCardResponse;

import com.abc.card.credit.repository.impl.CreditCardRepositoryImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import spring.CardServicesConfigurationTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(classes = {CardServicesConfigurationTest.class})
public class CreditCardTestMock {
    @Autowired
    CreditCardService creditCardService;

    @Mock
    CreditCardRepositoryImpl creditCardRepositoryImpl;

    List<CardDetailDTO> cardDetailDTOList = new ArrayList();
    ObjectMapper mapper = new ObjectMapper();

    String cardDetails="[{\"name\":\"Rewards Credit Cards\",\"code\":\"CRD-1001\"},{\"name\":\"Premium Rewards Credit Cards\"}]";

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        getCardDetailDTOList();
    }

    @Test
    public void whenCreditCardAvailableWithMock(){
        when(creditCardRepositoryImpl.getAvailableCardByType("CRT-001")).thenReturn(cardDetailDTOList);
        List<CreditCardResponse> responseList = creditCardService.getAvailableCreditCards();
        System.out.println(responseList);
        assertNotNull(responseList);
    }

    @Test
    public void whenCreditCardAvailableWithMockResponse(){
        when(creditCardRepositoryImpl.getAvailableCardByType("CRT-001")).thenReturn(cardDetailDTOList);
        List<CreditCardResponse> responseList = creditCardService.getAvailableCreditCards();
        System.out.println(responseList);
        assertNotNull(responseList);
    }
    /**
     *
     * @return
     */
    private List<CardDetailDTO> getCardDetailDTOList(){
    List<CardDetailDTO> cardDetailDTOList = new ArrayList<>();
     try {
        cardDetailDTOList = mapper.readValue(cardDetails, new TypeReference<List<CardDetailDTO>>() {});
    }catch (Exception e ){
        e.printStackTrace();
    }
     return cardDetailDTOList;
     }
}
