package com.abc.card.credit.service.user;

import com.abc.card.credit.pojo.card.credit.CustomerCardDetailDTO;
import com.abc.card.credit.pojo.card.credit.response.CustomerCardDetailResponse;
import com.abc.card.credit.pojo.user.request.CustomerRequest;
import com.abc.card.credit.pojo.user.response.CustomerResponse;
import com.abc.card.credit.repository.user.CustomerRepository;
import com.abc.card.credit.service.processor.UserProcessor;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {
    @Inject
    CustomerRepository customerRepositoryImpl;

    @Inject
    UserProcessor userProcessor;

    /**
     * Method to validate whether customer already exists with given email Id. If yes then return true else false
     * @param emailId
     * @return
     */
    public Map<String,Boolean> validateCustomerByEmailId(final String emailId){
        if(customerRepositoryImpl.getCustomerbyEmailId(emailId) > 0){
            return Map.of("status",true);
        }
        return Map.of("status",false);
    }

    /**
     * Methhod to fetch list of customer
     * @return
     */
    public List<CustomerResponse> getCustomer(){
        return userProcessor.prepareCustomerResponse(customerRepositoryImpl.getCustomer());
    }

    /**
     *
     * @param emailId
     * @param applicationStatus
     * @return
     */
    public List<CustomerCardDetailResponse> getCustomerCreditCardByEmailIdOrStatusOrBoth(final String emailId,final String applicationStatus){
        return fetchCustomerCreditCardByStatus(emailId,  applicationStatus);
    }

    /**
     *
     * @param emailId
     * @return
     */
    public List<CustomerCardDetailResponse>  getCustomerCreditCardByEmailId(final String emailId){
        return fetchCustomerCreditCardByStatus(emailId, null);
    }

    /**
     * Method to fetch card detail for given application status if status null then it will return all customer cards
     * @param status
     * @return
     */
    public List<CustomerCardDetailResponse> getCustomerCreditCardByStatusOrAll(final String status){
        return fetchCustomerCreditCardByStatus(null, status);
    }

    /**
     *
     * @param emailId
     * @param applicationStatus
     * @return
     */
    private List<CustomerCardDetailResponse>  fetchCustomerCreditCardByStatus(final String emailId, final String applicationStatus){
        return userProcessor.prepareCustomerCardDetailResponse(customerRepositoryImpl.fetchCustomerCreditCardByStatusOrAll(emailId,applicationStatus));
    }

    public CustomerCardDetailResponse getCustomerCreditCardByStatusId(final String statusId){
        return userProcessor.prepareCustomerCardDetailResponse(customerRepositoryImpl.fetchCustomerCreditCardByStatusId(statusId));
    }

    /**
     *
     * @return
     */
    public Map<String,Boolean> saveCustomerDetails(CustomerRequest customerRequest){
        return Map.of("status",true);
    }


}
