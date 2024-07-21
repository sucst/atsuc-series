package cn.atsuc.dev.domain;

import cn.atsuc.dev.employee.model.entity.EmployeeInfoEntity;
import cn.atsuc.dev.employee.service.IEmployeeService;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author atsuc
 * @date 2024/6/24 23:30
 * @email s202011105851@163.com
 * @description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class IEmployeeServiceTest {

    @Resource
    private IEmployeeService employeeService;

    @Test
    public void test_insertEmployeeInfo() {
        EmployeeInfoEntity employeeInfo = new EmployeeInfoEntity();
        employeeInfo.setEmployeeNumber("10000022");
        employeeInfo.setEmployeeName("小卡拉米");
        employeeInfo.setEmployeeLevel("T1");
        employeeInfo.setEmployeeTitle("实习工程师");
        employeeInfo.setSalaryTotalAmount(new BigDecimal("100"));
        employeeInfo.setSalaryMeritAmount(new BigDecimal("10"));
        employeeInfo.setSalaryBaseAmount(new BigDecimal("90"));
        employeeService.insertEmployeeInfo(employeeInfo);
    }

    @Test
    public void test_queryEmployInfo() {
        EmployeeInfoEntity employeeInfoEntity = employeeService.queryEmployeeInfo("10000001");
        log.info("测试结果：{}", JSON.toJSONString(employeeInfoEntity));

    }

}
