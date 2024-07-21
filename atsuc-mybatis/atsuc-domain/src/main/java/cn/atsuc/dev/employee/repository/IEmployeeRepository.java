package cn.atsuc.dev.employee.repository;

import cn.atsuc.dev.employee.model.entity.EmployeeInfoEntity;

/**
 * @author atsuc
 * @date 2024/6/24 21:08
 * @email s202011105851@163.com
 * @description
 */
public interface IEmployeeRepository {

    void insertEmployeeInfo(EmployeeInfoEntity employeeInfoEntity);

    EmployeeInfoEntity queryEmployeeInfo(String employNumber);

}
