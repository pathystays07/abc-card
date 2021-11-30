package com.abc.card.credit.repository;

import com.abc.card.credit.pojo.card.credit.CardDetailDTO;

import java.util.List;

public interface CreditCardRepository {
    List<CardDetailDTO> getAvailableCardByType(final String cardType);
    List<CardDetailDTO> getCardAndOfferByType(final String cardType);
}
