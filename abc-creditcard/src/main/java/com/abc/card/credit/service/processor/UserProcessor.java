package com.abc.card.credit.service.processor;

import com.abc.card.credit.pojo.card.credit.CustomerCardDetailDTO;
import com.abc.card.credit.pojo.card.credit.response.CustomerCardDetailResponse;
import com.abc.card.credit.pojo.rolePrivilege.PrivilegeDTO;
import com.abc.card.credit.pojo.user.CustomerDetailsDTO;
import com.abc.card.credit.pojo.user.EmployeeDetailDTO;
import com.abc.card.credit.pojo.user.response.CustomerResponse;
import com.abc.card.credit.pojo.user.response.EmployeResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Named
public class UserProcessor {

    /**
     *
     * @param employeeList
     * @return
     */
    public List<EmployeResponse> convertEmplyeeDTOIntoResponse(final List<EmployeeDetailDTO> employeeList){

        if(!CollectionUtils.isEmpty(employeeList)){
           return employeeList.stream().map( response -> {
                EmployeResponse employeResponse = new EmployeResponse();
                employeResponse.setEmployeeCode(response.getEmployeeCode());
                employeResponse.setEmailId(response.getEmailId());
                employeResponse.setName(response.getName());
                employeResponse.setPhoneNumber(response.getPhoneNumber());
                return employeResponse;
            }).collect(Collectors.toList());

        }
        return new ArrayList();
    }

    /**
     *
     * @param customerList
     * @return
     */
    public List<CustomerResponse> prepareCustomerResponse(final List<CustomerDetailsDTO> customerList){

        if(!CollectionUtils.isEmpty(customerList)){
            return customerList.stream().map( response -> {
                CustomerResponse customerResponse = new CustomerResponse();
                customerResponse.setCode(response.getCode());
                customerResponse.setEmailId(response.getEmailId());
                customerResponse.setName(response.getName());
                customerResponse.setPhoneNumber(response.getPhoneNumber());
                return customerResponse;
            }).collect(Collectors.toList());
        }
        return new ArrayList();
    }

    /**
     *
     * @param customerCardDetailDTOList
     * @return
     */
    public List<CustomerCardDetailResponse> prepareCustomerCardDetailResponse(final List<CustomerCardDetailDTO> customerCardDetailDTOList){
        if(!CollectionUtils.isEmpty(customerCardDetailDTOList)){
            customerCardDetailDTOList.stream().map( req -> {
                CustomerCardDetailResponse customerCardDetailResponse = new CustomerCardDetailResponse();
                customerCardDetailResponse.setCardName(req.getCardName());
                customerCardDetailResponse.setApplicationStatusCode(req.getApplicationStatusCode());
                customerCardDetailResponse.setApplicationStatusValue(req.getApplicationStatusValue());
                customerCardDetailResponse.setApplicationStatusDesc(req.getApplicationStatusDesc());
                if(StringUtils.isNotBlank(req.getName())){
                    customerCardDetailResponse.setName(req.getName());
                }
                if(StringUtils.isNotBlank(req.getEmailId())){
                    customerCardDetailResponse.setEmailId(req.getEmailId());
                }
                return customerCardDetailResponse;
            }).collect(Collectors.toList());
        }
        return new ArrayList();
    }

    /**
     *
     * @param customerCardDetailDTO
     * @return
     */
    public CustomerCardDetailResponse prepareCustomerCardDetailResponse(final CustomerCardDetailDTO customerCardDetailDTO){
        if(Objects.nonNull(customerCardDetailDTO)){
                CustomerCardDetailResponse customerCardDetailResponse = new CustomerCardDetailResponse();
                customerCardDetailResponse.setCardName(customerCardDetailDTO.getCardName());
                customerCardDetailResponse.setApplicationStatusCode(customerCardDetailDTO.getApplicationStatusCode());
                customerCardDetailResponse.setApplicationStatusValue(customerCardDetailDTO.getApplicationStatusValue());
                customerCardDetailResponse.setApplicationStatusDesc(customerCardDetailDTO.getApplicationStatusDesc());
                if(StringUtils.isNotBlank(customerCardDetailDTO.getName())){
                    customerCardDetailResponse.setName(customerCardDetailDTO.getName());
                }
                if(StringUtils.isNotBlank(customerCardDetailDTO.getEmailId())){
                    customerCardDetailResponse.setEmailId(customerCardDetailDTO.getEmailId());
                }
                return customerCardDetailResponse;
        }
        return new CustomerCardDetailResponse();
    }

    /**
     * Method will check whether given privilege code exists in list if yes then return true else false
     * @param privilegeDTOList
     * @param privilegeCode
     * @return
     */
    public boolean checkUserHasAccessFetchCardStatus(List<PrivilegeDTO> privilegeDTOList, String privilegeCode){
        if(!CollectionUtils.isEmpty(privilegeDTOList)){
            Optional<PrivilegeDTO> count = privilegeDTOList.stream().filter(req -> StringUtils.equalsIgnoreCase(req.getPrivilegeName(),privilegeCode)).findFirst();
            return count.isPresent();
        }
        return false;
    }
}
