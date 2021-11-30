package com.abc.card.credit.repository.mapper;

import com.abc.card.credit.pojo.card.credit.CardDetailDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CardMapper {

    @Results(id = "cardDetails", value = { @Result(column = "CARD_CODE", property = "code"),@Result(column = "CARD_NAME", property = "name")})
    @Select("SELECT CARD_CODE,CARD_NAME FROM TG_CARD T1, TG_CARD_TYPE T2 WHERE T1.TYPE_ID=T2.TYPE_ID AND T2.TYPE_CODE=#{cardType} ")
    List<CardDetailDTO> getAvailableCardByType(@Param("cardType") String cardType);

    @Results(id = "cardEligibleDetails", value = { @Result(column = "CARD_CODE", property = "code"),@Result(column = "CARD_NAME", property = "name"),
            @Result(column = "ANNUAL_CHARGE", property = "annualFees"),@Result(column = "ANNUAL_CHARGE", property = "offers")
            ,@Result(column = "ELIGIBLE_AGE", property = "eligibleAge"),@Result(column = "ELIGIBLE_SALARY", property = "salary"),
            @Result(column = "ELIGIBLE_SALARIED", property = "salaried")})
    @Select("SELECT T1.CARD_CODE,T1.CARD_NAME,T5.INTEREST,T5.ANNUAL_CHARGE,T6.ELIGIBLE_AGE,T6.ELIGIBLE_SALARY,T6.ELIGIBLE_SALARIED FROM TG_CARD T1," +
            " TG_CARD_TYPE T2 , TG_CARD_ELIGIBLE_OFFER t3 , TG_ELIGIBLE_OFFER T4 , TG_CARD_PRICE_OFFER T5,TG_ELIGIBLE_CATEGORY T6 WHERE " +
            "T1.TYPE_ID=T2.TYPE_ID AND T2.TYPE_CODE=#{cardType} AND T3.CARD_ID=T1.CARD_ID AND T4.ELIGIBLE_OFFER_ID=T3.ELIGIBLE_OFFER_ID " +
            "AND T5.PRICE_OFFER_ID=T4.PRICE_OFFER_ID AND T6.ELIGIBLE_ID=T4.ELIGIBLE_ID")
    List<CardDetailDTO> getCardAndOfferByType(@Param("cardType") String cardType);
}
