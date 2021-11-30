package com.abc.card.credit.controller.user.employee;

import com.abc.card.credit.pojo.card.credit.response.CustomerCardDetailResponse;
import com.abc.card.credit.pojo.user.response.EmployeResponse;
import com.abc.card.credit.service.user.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Inject
    EmployeeService employeeService;

    @GetMapping("/all")
    public List<EmployeResponse> getEmployeeDetails(){
        return employeeService.getEmployee();
    }

    @GetMapping("/customer/card/status")
    public List<CustomerCardDetailResponse> getCreditCardByStatus(@RequestParam String emailId, @RequestParam(required = false) String status) throws Exception {
        return employeeService.getCardApplicationStatusByTypeOrStatus(emailId,status);
    }
    @PutMapping("/card/status/update")
    public Map<String,Boolean> UpdateCustomerCreditCardByStatusId(@RequestParam String emailId, @RequestParam String appStatusId, @RequestParam String statusCode) throws Exception {
        return employeeService.approveOrRejectCard(emailId,appStatusId,statusCode);
    }
    @PutMapping("/card/update/tracking/details")
    public Map<String,Boolean> UpdateCreditCardTrackingDetails(@RequestParam String emailId, @RequestParam String cardStatusId, @RequestParam String shipperName) throws Exception {
        return employeeService.approveOrRejectCard(emailId,cardStatusId,shipperName);
    }
}
