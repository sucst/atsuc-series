package cn.atsuc.dev.infrastucture;

import cn.atsuc.dev.dao.IEmployeeSalaryAdjustDao;
import cn.atsuc.dev.po.EmployeeSalaryAdjustPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author atsuc
 * @date 2024/6/25 0:39
 * @email s202011105851@163.com
 * @description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class IEmployeeSalaryAdjustDAOTest {
    @Resource
    private IEmployeeSalaryAdjustDao employeeSalaryAdjustDao;

    @Test
    public void test_insert() {
        EmployeeSalaryAdjustPO employeeSalaryAdjust = new EmployeeSalaryAdjustPO();
        employeeSalaryAdjust.setEmployeeNumber("10000001");
        employeeSalaryAdjust.setAdjustOrderId("10908999019884511");
        employeeSalaryAdjust.setAdjustTotalAmount(new BigDecimal(1000));
        employeeSalaryAdjust.setAdjustBaseAmount(new BigDecimal(800));
        employeeSalaryAdjust.setAdjustMeritAmount(new BigDecimal(200));
        employeeSalaryAdjustDao.insert(employeeSalaryAdjust);
    }

}
