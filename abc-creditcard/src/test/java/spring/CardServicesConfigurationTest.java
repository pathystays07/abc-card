package spring;

import com.abc.card.credit.repository.CreditCardRepository;
import com.abc.card.credit.repository.impl.CreditCardRepositoryImpl;
import com.abc.card.credit.repository.impl.user.CustomerRepositoryImpl;
import com.abc.card.credit.repository.impl.user.EmployeeRepositoryImpl;
import com.abc.card.credit.repository.user.CustomerRepository;
import com.abc.card.credit.repository.user.EmployeeRepository;
import com.abc.card.credit.service.CreditCardService;
import com.abc.card.credit.service.processor.CreditProcessor;
import com.abc.card.credit.service.processor.UserProcessor;
import com.abc.card.credit.service.user.CustomerService;
import com.abc.card.credit.service.user.EmployeeService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@TestConfiguration
@Import(value = {CardServicesDataBaseConfigurationTest.class})

public class CardServicesConfigurationTest {
    @Bean
    public CreditCardService getCreditCardService(){
        return new CreditCardService();
    }
    @Bean
    public CreditProcessor getCreditProcessor(){
        return new CreditProcessor();
    }
    @Bean
    public CreditCardRepository getCreditCardRepository(){
        return new CreditCardRepositoryImpl();
    }

    @Bean
    public EmployeeService getEmployeeService(){
        return new EmployeeService();
    }

    @Bean
    public CustomerService getCustomerService(){
        return new CustomerService();
    }

    @Bean
    public UserProcessor getUserProcessor(){
        return new UserProcessor();
    }
    @Bean
    public EmployeeRepository getEmployeeRepository(){
        return new EmployeeRepositoryImpl();
    }

    @Bean
    public CustomerRepository getCustomerRepository(){
        return new CustomerRepositoryImpl();
    }


//    @Bean
//    public CardMapper cardMapper(){
//        return Mappers.getMapper(CardMapper.class);
//    }
}
