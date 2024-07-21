package cn.atsuc.dev.dao;

import cn.atsuc.dev.po.EmployeeSalaryAdjustPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author atsuc
 * @date 2024/6/24 21:46
 * @email s202011105851@163.com
 * @description
 */
@Mapper
public interface IEmployeeSalaryAdjustDao {

    void insert(EmployeeSalaryAdjustPO employeeSalaryAdjustPO);

}
