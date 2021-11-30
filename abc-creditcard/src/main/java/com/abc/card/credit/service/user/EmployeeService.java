package com.abc.card.credit.service.user;

import com.abc.card.CardConstant;
import com.abc.card.credit.pojo.card.credit.response.CustomerCardDetailResponse;
import com.abc.card.credit.pojo.rolePrivilege.PrivilegeDTO;
import com.abc.card.credit.pojo.user.EmployeeDetailDTO;
import com.abc.card.credit.pojo.user.response.EmployeResponse;
import com.abc.card.credit.repository.user.EmployeeRepository;
import com.abc.card.credit.service.processor.UserProcessor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class EmployeeService {

    @Inject
    EmployeeRepository employeeRepositoryImpl;

    @Inject
    UserProcessor userProcessor;

    @Inject
    CustomerService customerService;

    public List<EmployeResponse> getEmployee(){
        return userProcessor.convertEmplyeeDTOIntoResponse(employeeRepositoryImpl.getEmployee());
    }

    /**
     *
     * @param emailId
     * @param status
     * @return
     * @throws Exception
     */
    public List<CustomerCardDetailResponse> getCardApplicationStatusByTypeOrStatus(final String emailId, final String status) throws Exception {
        // Method to check whether user has required privilege to fetch card details
        checkUserHasAccessToGetCardDetails(emailId);
        return customerService.getCustomerCreditCardByStatusOrAll(null);
    }

    /**
     * Method to fetch employee detail for given email Id
     * @param emailId
     * @return
     */
//    public EmployeResponse getEmployeeDetailsByEmailId(final String emailId){
//        return employeeRepositoryImpl.getEmployeeByEmailId(emailId);
//    }
    private EmployeeDetailDTO fetchEmployeeDetailsByEmailId(final String emailId){
        return employeeRepositoryImpl.getEmployeeByEmailId(emailId);
    }

    /**
     *
     * @param employeeCode
     * @return
     */
    public List<PrivilegeDTO> fetchPrivilegeByEmployeeCode(final String employeeCode){
        return employeeRepositoryImpl.getPrivilegeByEmployeeCode(employeeCode);
    }

    /**
     * Method to validate whether user has access and then fetch card details for given application Status Id
     * @param emailId
     * @param appStatusId
     * @return
     * @throws Exception
     */
    public CustomerCardDetailResponse getCardApplicationByStatusId(final String emailId, final String appStatusId) throws Exception {
        // Method to check whether user has required privilege to fetch card details
        checkUserHasAccessToGetCardDetails(emailId);
        // fetch card details for given application Status Id
        return customerService.getCustomerCreditCardByStatusId(appStatusId);
    }

    /**
     * Method will validate whether has required privilge to approve or reject card request if yes then proceed further else throw exception message
     * @param emailId
     * @param appStatusId
     * @param statusCode
     * @return
     * @throws Exception
     */
    public Map<String,Boolean> approveOrRejectCard(final String emailId,final String appStatusId,final String statusCode) throws Exception {
        // Method to check whether user has required privilege to approve or reject card details
        checkUserHasAccessToApproveCard(emailId);
        // throw exception if application status does not exists for given status Id
        if(updateCardStatus(appStatusId,statusCode) == 0 ){
            throw new Exception();
        }
        return Map.of("status",true);
    }

    /**
     *
     * @return
     * @throws Exception
     */
    private boolean checkUserHasAccessToGetCardDetails(final String emailId) throws Exception {
        EmployeeDetailDTO  employeeDetailDTO = fetchEmployeeDetailsByEmailId( emailId);
        if( Objects.isNull(employeeDetailDTO)){
            throw new Exception();
        }
        //get privilege Id for given employeeCode
        List<PrivilegeDTO> privilegeDTOList = fetchPrivilegeByEmployeeCode(employeeDetailDTO.getEmployeeCode());
        if(CollectionUtils.isEmpty(privilegeDTOList)){
            throw new Exception();
        }
        if( !userProcessor.checkUserHasAccessFetchCardStatus(privilegeDTOList, CardConstant.VIEW_CREDIT_CARD_REQUEST)){
            throw new Exception();
        }
        return true;
    }

    /**
     * Method to check whether user has required privilege to approve card request
     * @param emailId
     * @return
     * @throws Exception
     */
    private boolean checkUserHasAccessToApproveCard(final String emailId) throws Exception {
        EmployeeDetailDTO  employeeDetailDTO = fetchEmployeeDetailsByEmailId( emailId);
        if( Objects.isNull(employeeDetailDTO)){
            throw new Exception();
        }
        //get privilege Id for given employeeCode
        List<PrivilegeDTO> privilegeDTOList = fetchPrivilegeByEmployeeCode(employeeDetailDTO.getEmployeeCode());
        if(CollectionUtils.isEmpty(privilegeDTOList)){
            throw new Exception();
        }
        if( !userProcessor.checkUserHasAccessFetchCardStatus(privilegeDTOList, CardConstant.APRROVE_CREDIT_CARD_REQUEST)){
            throw new Exception();
        }
        return true;
    }

    /**
     *
     * @param appStatusId
     * @param statusCode
     * @return
     */
    private Integer updateCardStatus(final String appStatusId,final String statusCode){
       return employeeRepositoryImpl.updateApplicationStatus(Integer.parseInt(appStatusId),statusCode);
    }
    private Integer updateCardTrackingDetails(final String appStatusId,final String trackingId,final String shipperName){
        return employeeRepositoryImpl.updateApplicationTrackingDetails(Integer.parseInt(appStatusId),trackingId,shipperName);
    }


}
