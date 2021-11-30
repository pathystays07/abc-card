package com.abc.card.credit.pojo.rolePrivilege.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrivilegeResponse {
    String privilegeId;
    String privilegeName;
    String privilegeDescription;
}
