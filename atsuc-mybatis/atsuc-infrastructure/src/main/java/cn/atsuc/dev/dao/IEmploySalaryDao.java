package cn.atsuc.dev.dao;

import cn.atsuc.dev.po.EmployeeSalaryPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author atsuc
 * @date 2024/6/24 21:24
 * @email s202011105851@163.com
 * @description
 */
@Mapper
public interface IEmploySalaryDao {

    void insert(EmployeeSalaryPO employeeSalary);

    void insertList(List<EmployeeSalaryPO> list);

    void update(EmployeeSalaryPO employeeSalaryPO);

    EmployeeSalaryPO queryEmployeeSalaryByEmployNumber(String employNumber);

}
