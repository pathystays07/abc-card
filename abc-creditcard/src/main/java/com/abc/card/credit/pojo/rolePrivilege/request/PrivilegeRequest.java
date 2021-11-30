package com.abc.card.credit.pojo.rolePrivilege.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrivilegeRequest {
    String privilegeId;
    String privilegeName;
    String privilegeDescription;
}
