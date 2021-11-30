package com.abc.card.credit.repository.impl.user;

import com.abc.card.credit.pojo.rolePrivilege.PrivilegeDTO;
import com.abc.card.credit.pojo.user.EmployeeDetailDTO;
import com.abc.card.credit.repository.mapper.user.EmployeeMapper;
import com.abc.card.credit.repository.user.EmployeeRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Inject
    EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDetailDTO> getEmployee() {
        return employeeMapper.getEmployee();
    }

    @Override
    public EmployeeDetailDTO getEmployeeByEmailId(String emailId) {
        return employeeMapper.getEmployeebyEmailId(emailId);
    }

    @Override
    public List<PrivilegeDTO> getPrivilegeByEmployeeCode(String employeeCode) {
        return employeeMapper.getPrivilegeByEmployeeCode(employeeCode);
    }

    @Override
    public Integer updateApplicationStatus( Integer appStatusId, String statusCode) {
        return employeeMapper.updateApplicationStatus(appStatusId, statusCode);
    }

    @Override
    public Integer updateApplicationTrackingDetails(Integer appStatusId, String trackingId, String shipperName) {
        return null;
    }
}
