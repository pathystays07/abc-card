package com.abc.card.credit.pojo.card.credit;

import lombok.Data;


@Data
public class CardDetailDTO {
    String name;
    String code;
    Integer annualFees;
    String cardType;
    Double offers;
    String eligibleAge;
    String salaried;
    Double salary;
}
