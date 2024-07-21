package cn.atsuc.dev.infrastucture;

import cn.atsuc.dev.dao.IEmployeeDao;
import cn.atsuc.dev.po.EmployeePO;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author atsuc
 * @date 2024/6/25 0:34
 * @email s202011105851@163.com
 * @description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class IEmployDaoTest {
    @Resource
    private IEmployeeDao employeeDao;

    @Test
    public void test_insert() {
        EmployeePO employee = new EmployeePO();
        employee.setEmployeeNumber("10000009");
        employee.setEmployeeName("小ge哥");
        employee.setEmployeeLevel("T2");
        employee.setEmployeeTitle("见习工程师");
        employeeDao.insert(employee);
    }

    @Test
    public void test_query() {
        EmployeePO employeePO = employeeDao.queryEmployeeByEmployNumber("10000002");
        log.info("测试结果：{}", JSON.toJSONString(employeePO));
    }

    @Test
    public void test_insert_list() {
        List<EmployeePO> list = new ArrayList<>();
        for (int i = 5; i < 8; i++) {
            EmployeePO employee = new EmployeePO();
            employee.setEmployeeNumber("10000018" + i);
            employee.setEmployeeName("花花");
            employee.setEmployeeLevel("T2");
            employee.setEmployeeTitle("见习工程师");
            list.add(employee);
        }
        employeeDao.insertList(list);
    }

}
