package com.abc.card.credit.repository.user;

import com.abc.card.credit.pojo.card.credit.CustomerCardDetailDTO;
import com.abc.card.credit.pojo.user.CustomerDetailsDTO;

import java.util.List;

public interface CustomerRepository {
     Integer getCustomerbyEmailId(final String emailId);
     List<CustomerDetailsDTO> getCustomer();
     List<CustomerCardDetailDTO> getCustomerCreditCardByEmailIdOrStatusOrBoth(final String emailId,final String applicationStatus);
     List<CustomerCardDetailDTO> fetchCustomerCreditCardByStatusOrAll(String emailId, String applicationStatus);
     CustomerCardDetailDTO fetchCustomerCreditCardByStatusId(String applicationStatusId);

}
