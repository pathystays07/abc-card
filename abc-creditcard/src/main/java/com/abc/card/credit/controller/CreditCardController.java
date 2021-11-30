package com.abc.card.credit.controller;

import com.abc.card.CardServiceURLConstant;
import com.abc.card.credit.pojo.card.credit.response.CreditCardResponse;
import com.abc.card.credit.service.CreditCardService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(CardServiceURLConstant.CARD_ROOT_PATH)
public class CreditCardController {

    @Inject
    CreditCardService creditCardService;
   @GetMapping("/credit")
    public List<CreditCardResponse> getAvailableCreditCard(){
    return creditCardService.getAvailableCreditCards();
    }

    @GetMapping("credit/eligible")
    public List<CreditCardResponse> getEligibleCreditCard(){
        return creditCardService.getEligibleAllCreditCard();
    }

    @GetMapping("/credit/type")
    public List<CreditCardResponse> getAvailableCardByType(){
        return null;
    }

    @GetMapping("/credit/code")
    public List<CreditCardResponse> getCreditCardByCode(){
        return null;
    }

    @GetMapping("/credit/offer")
    public List<CreditCardResponse> getCreditCardAndOffering(){
        return null;
    }


}
