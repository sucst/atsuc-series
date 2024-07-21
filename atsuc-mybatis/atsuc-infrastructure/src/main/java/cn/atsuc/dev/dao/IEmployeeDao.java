package cn.atsuc.dev.dao;

import cn.atsuc.dev.po.EmployeePO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author atsuc
 * @date 2024/6/24 21:24
 * @email s202011105851@163.com
 * @description
 */
@Mapper
public interface IEmployeeDao {

    void insert(EmployeePO employee);

    void insertList(List<EmployeePO> list);

    void update(EmployeePO employeePO);

    EmployeePO queryEmployeeByEmployNumber(String employNumber);

}
