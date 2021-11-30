/**
 *
 */
package com.abc.card.credit.controller.user.customer;

import com.abc.card.CardServiceURLConstant;
import com.abc.card.credit.pojo.card.credit.response.CustomerCardDetailResponse;
import com.abc.card.credit.pojo.user.request.CustomerRequest;
import com.abc.card.credit.pojo.user.response.CustomerResponse;
import com.abc.card.credit.service.user.CustomerService;

import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Get customer details
 */
@RestController
@RequestMapping(CardServiceURLConstant.CUSTOMER_ROOT_PATH)
public class CustomerController {

    @Inject
    CustomerService customerService;

    @GetMapping(CardServiceURLConstant.CUSTOMER_VALIDATE_EMAIL_PATH)
    public Map<String,Boolean> validateCustomerbyEmailId(@RequestParam String emailId){
        return customerService.validateCustomerByEmailId(emailId);
    }

    @GetMapping(CardServiceURLConstant.GET_CUSTOMER_PATH)
    public List<CustomerResponse> getCustomer(){
        return customerService.getCustomer();
    }

    @PostMapping(CardServiceURLConstant.SAVE_CUSTOMER_PATH)
    public Map<String,Boolean> save(@RequestBody CustomerRequest customerRequest){
        return customerService.saveCustomerDetails(customerRequest);
    }

    /**
     *
     * @param emailId
     * @param status
     * @return
     */
    @GetMapping(CardServiceURLConstant.CARD_STATUS_PATH)
    public List<CustomerCardDetailResponse> getCustomerCreditCardByEmailIdOrStausOrBoth(@RequestParam String emailId, @RequestParam(required = false) String status){
        return customerService.getCustomerCreditCardByEmailIdOrStatusOrBoth(emailId,status);
    }
}
