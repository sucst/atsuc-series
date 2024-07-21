package cn.atsuc.dev.employee.service;

import cn.atsuc.dev.employee.model.entity.EmployeeInfoEntity;

/**
 * @author atsuc
 * @date 2024/6/24 21:10
 * @email s202011105851@163.com
 * @description
 */
public interface IEmployeeService {

    void insertEmployeeInfo(EmployeeInfoEntity employeeInfoEntity);

    EmployeeInfoEntity queryEmployeeInfo(String employNumber);

}
