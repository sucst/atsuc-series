package cn.atsuc.dev.infrastucture;

import cn.atsuc.dev.dao.IEmploySalaryDao;
import cn.atsuc.dev.po.EmployeeSalaryPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author atsuc
 * @date 2024/6/25 0:41
 * @email s202011105851@163.com
 * @description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class IEmployeeSalaryDAOTest {
    @Resource
    private IEmploySalaryDao employeeSalaryDAO;

    @Test
    public void test_insert() {
        EmployeeSalaryPO employeeSalary = new EmployeeSalaryPO();
        employeeSalary.setEmployeeNumber("10000001");
        employeeSalary.setSalaryTotalAmount(new BigDecimal("5000"));
        employeeSalary.setSalaryMeritAmount(new BigDecimal("1000"));
        employeeSalary.setSalaryBaseAmount(new BigDecimal("4000"));
        employeeSalaryDAO.insert(employeeSalary);
    }

    @Test
    public void test_insert_list() {
        List<EmployeeSalaryPO> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            EmployeeSalaryPO employeeSalary = new EmployeeSalaryPO();
            employeeSalary.setEmployeeNumber("1000001" + i);
            employeeSalary.setSalaryTotalAmount(new BigDecimal("5000"));
            employeeSalary.setSalaryMeritAmount(new BigDecimal("1000"));
            employeeSalary.setSalaryBaseAmount(new BigDecimal("4000"));
            list.add(employeeSalary);
        }
        employeeSalaryDAO.insertList(list);
    }

}
