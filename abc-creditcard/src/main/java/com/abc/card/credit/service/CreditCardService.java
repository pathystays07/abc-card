package com.abc.card.credit.service;




import com.abc.card.CardConstant;
import com.abc.card.credit.pojo.card.credit.CardDetailDTO;
import com.abc.card.credit.pojo.card.credit.response.CreditCardResponse;
import com.abc.card.credit.repository.CreditCardRepository;
import com.abc.card.credit.service.processor.CreditProcessor;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CreditCardService {

    @Inject
    CreditCardRepository creditCardRepositoryImpl;

    @Inject
    CreditProcessor creditProcessor;
    /**
     * Method will return list of credit cards offered by abc bank
     */
    public List<CreditCardResponse> getEligibleAllCreditCard(){
        return fetchCardAndOffer(CardConstant.CREDIT_CARD_TYPE_CODE);
    }
    /**
     *
     * @return
     */
    public List<CreditCardResponse> getAvailableCreditCards(){
       return fetchAvailableCardByType(CardConstant.CREDIT_CARD_TYPE_CODE);
    }

    /**
     *
     * @param cardType
     * @return
     */
    public List<CreditCardResponse> getAvailableCardsByType(String  cardType){
        return fetchAvailableCardByType(cardType);
    }

    /**
     *
     * @param cardType
     * @return
     */
    private List<CreditCardResponse> fetchAvailableCardByType(final String cardType){
        return creditProcessor.convertCreditDTOIntoReponse(creditCardRepositoryImpl.getAvailableCardByType(cardType));
    }

    /**
     *
     * @return
     */
    private List<CreditCardResponse> fetchCardAndOffer(final String cardType){
        return creditProcessor.prepareEligibleCardResponse(creditCardRepositoryImpl.getCardAndOfferByType(cardType));
    }

}
