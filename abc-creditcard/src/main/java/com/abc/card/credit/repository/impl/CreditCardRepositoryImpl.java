package com.abc.card.credit.repository.impl;

import com.abc.card.credit.pojo.card.credit.CardDetailDTO;
import com.abc.card.credit.repository.CreditCardRepository;
import com.abc.card.credit.repository.mapper.CardMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class CreditCardRepositoryImpl implements CreditCardRepository {

    @Inject
    CardMapper cardMapper;

    @Override
    public List<CardDetailDTO> getAvailableCardByType(String cardType) {
        return cardMapper.getAvailableCardByType(cardType);
    }

    @Override
    public List<CardDetailDTO> getCardAndOfferByType(String cardType) {

        return cardMapper.getCardAndOfferByType(cardType);
    }
}
