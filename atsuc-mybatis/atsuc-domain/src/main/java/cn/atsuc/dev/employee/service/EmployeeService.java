package cn.atsuc.dev.employee.service;

import cn.atsuc.dev.employee.model.entity.EmployeeInfoEntity;
import cn.atsuc.dev.employee.repository.IEmployeeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author atsuc
 * @date 2024/6/24 21:12
 * @email s202011105851@163.com
 * @description
 */
@Service
public class EmployeeService  implements IEmployeeService {

    @Resource
    private IEmployeeRepository employeeRepository;

    @Override
    public void insertEmployeeInfo(EmployeeInfoEntity employeeInfoEntity) {
        employeeRepository.insertEmployeeInfo(employeeInfoEntity);
    }

    @Override
    public EmployeeInfoEntity queryEmployeeInfo(String employNumber) {
        return employeeRepository.queryEmployeeInfo(employNumber);
    }
}
