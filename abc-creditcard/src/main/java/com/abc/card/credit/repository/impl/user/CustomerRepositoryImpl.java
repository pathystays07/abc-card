package com.abc.card.credit.repository.impl.user;

import com.abc.card.credit.pojo.card.credit.CustomerCardDetailDTO;
import com.abc.card.credit.pojo.user.CustomerDetailsDTO;
import com.abc.card.credit.repository.mapper.user.CustomerMapper;
import com.abc.card.credit.repository.user.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Inject
    CustomerMapper customerMapper;

    @Override
    public Integer getCustomerbyEmailId(String emailId) {
        return customerMapper.getCustomerByEmailId(emailId);
    }

    @Override
    public List<CustomerDetailsDTO> getCustomer() {
        return customerMapper.getCustomer();
    }

    @Override
    public List<CustomerCardDetailDTO> getCustomerCreditCardByEmailIdOrStatusOrBoth(String emailId, String applicationStatus) {
        return customerMapper.getCustomerCreditCardByEmailIdOrStatusOrBoth(emailId,applicationStatus);
    }

    @Override
    public List<CustomerCardDetailDTO> fetchCustomerCreditCardByStatusOrAll(String emailId, String applicationStatus) {
        return customerMapper.fetchCustomerCreditCardByEmailIdOrStatusOrBoth(emailId,applicationStatus);
    }

    @Override
    public CustomerCardDetailDTO fetchCustomerCreditCardByStatusId(String applicationStatusId) {
        return customerMapper.fetchCustomerCreditCardByStatusId(applicationStatusId);
    }
}

