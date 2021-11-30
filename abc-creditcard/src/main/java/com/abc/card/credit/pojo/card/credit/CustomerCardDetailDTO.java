package com.abc.card.credit.pojo.card.credit;

import lombok.Data;


@Data
public class CustomerCardDetailDTO {
    String name;
    String emailId;
    String cardName;
    String applicationStatusCode;
    String applicationStatusDesc;
    String applicationStatusValue;
    String comments;
}
