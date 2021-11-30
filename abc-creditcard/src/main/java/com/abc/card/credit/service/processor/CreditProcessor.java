package com.abc.card.credit.service.processor;

import com.abc.card.CardConstant;
import com.abc.card.credit.pojo.card.credit.CardDetailDTO;
import com.abc.card.credit.pojo.card.credit.response.CreditCardResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.NumberUtils;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class CreditProcessor {

    /**
     *
     * @param cardDetailDTO
     * @return
     */
    public List<CreditCardResponse> convertCreditDTOIntoReponse(final List<CardDetailDTO> cardDetailDTO){
        if(!CollectionUtils.isEmpty(cardDetailDTO)){
         return  cardDetailDTO.stream().map(request -> {
                CreditCardResponse creditCardResponse = new CreditCardResponse();
                creditCardResponse.setName(request.getName());
                creditCardResponse.setCode(request.getCode());
                return creditCardResponse;
            }).collect(Collectors.toList());
        }
        return new ArrayList();
    }

    /**
     *
     * @param cardDetailDTO
     * @return
     */
    public List<CreditCardResponse> prepareEligibleCardResponse(final List<CardDetailDTO> cardDetailDTO){
        if(!CollectionUtils.isEmpty(cardDetailDTO)){
           return cardDetailDTO.stream().map(request -> {
                CreditCardResponse creditCardResponse = new CreditCardResponse();
                creditCardResponse.setName(request.getName());
                creditCardResponse.setCode(request.getCode());
              if(StringUtils.isNotBlank(request.getEligibleAge())){
                  creditCardResponse.setEligibleAge(request.getEligibleAge());
              }
              if(StringUtils.isNotBlank(request.getSalaried())){
                  creditCardResponse.setSalaried(StringUtils.equalsIgnoreCase(request.getSalaried(), CardConstant.VALUE_N) ? true : false);
              }
              if( null != request.getSalary()){
                  creditCardResponse.setSalary(Double.valueOf(request.getSalary()).longValue());
              }
                return creditCardResponse;
            }).collect(Collectors.toList());
        }
        return new ArrayList();
    }
}
