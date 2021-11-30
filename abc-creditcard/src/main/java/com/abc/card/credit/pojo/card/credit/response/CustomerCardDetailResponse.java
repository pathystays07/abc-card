package com.abc.card.credit.pojo.card.credit.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerCardDetailResponse {
    String name;
    String emailId;
    String cardName;
    String applicationStatusCode;
    String applicationStatusDesc;
    String applicationStatusValue;
    String comments;
}
