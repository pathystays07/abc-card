package com.abc.card.credit.pojo.card.credit.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCardResponse implements Serializable {
    @Schema(description = "Name of the creditCard")
    String name;
    @Schema(description = "Card code")
    String code;
    @Schema(description = "credit card annual fees")
    Integer annualFees;
    @Schema(description = "Offers available for creditCard")
    Double offers;

    @Schema(description = "Eligible age for apply credit card")
    String eligibleAge;
    @Schema(description = " customer is salaried person or not")
    Boolean salaried;
    @Schema(description = "Salary eligibilty")
    Long salary;
}
