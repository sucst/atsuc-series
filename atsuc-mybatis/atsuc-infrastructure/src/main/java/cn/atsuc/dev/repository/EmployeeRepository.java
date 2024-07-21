package cn.atsuc.dev.repository;

import cn.atsuc.dev.dao.IEmploySalaryDao;
import cn.atsuc.dev.dao.IEmployeeDao;
import cn.atsuc.dev.employee.model.entity.EmployeeInfoEntity;
import cn.atsuc.dev.employee.repository.IEmployeeRepository;
import cn.atsuc.dev.po.EmployeePO;
import cn.atsuc.dev.po.EmployeeSalaryPO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * @author atsuc
 * @date 2024/6/24 21:22
 * @email s202011105851@163.com
 * @description
 */
@Repository
public class EmployeeRepository implements IEmployeeRepository {

    @Resource
    private IEmployeeDao employeeDao;
    @Resource
    private IEmploySalaryDao employSalaryDao;
    @Resource
    private TransactionTemplate transactionTemplate;
    @Override
    public void insertEmployeeInfo(EmployeeInfoEntity employeeInfoEntity) {
         transactionTemplate.execute(new TransactionCallbackWithoutResult() {
             @Override
             protected void doInTransactionWithoutResult(TransactionStatus status) {
                 try {
                     EmployeePO employeePO = EmployeePO.builder()
                             .employeeNumber(employeeInfoEntity.getEmployeeNumber())
                             .employeeName(employeeInfoEntity.getEmployeeName())
                             .employeeLevel(employeeInfoEntity.getEmployeeLevel())
                             .employeeTitle(employeeInfoEntity.getEmployeeTitle())
                             .build();

                     employeeDao.insert(employeePO);

                     EmployeeSalaryPO employeeSalaryPO = EmployeeSalaryPO.builder()
                             .employeeNumber(employeeInfoEntity.getEmployeeNumber())
                             .salaryTotalAmount(employeeInfoEntity.getSalaryTotalAmount())
                             .salaryMeritAmount(employeeInfoEntity.getSalaryMeritAmount())
                             .salaryBaseAmount(employeeInfoEntity.getSalaryBaseAmount())
                             .build();

                     employSalaryDao.insert(employeeSalaryPO);
                 } catch (Exception e) {
                     status.setRollbackOnly(); // 事务回滚
                     e.printStackTrace();
                 }
             }
         });
    }

    @Override
    public EmployeeInfoEntity queryEmployeeInfo(String employNumber) {
        // 查询雇员
        EmployeePO employeePO = employeeDao.queryEmployeeByEmployNumber(employNumber);
        // 查询薪资
        EmployeeSalaryPO employeeSalaryPO = employSalaryDao.queryEmployeeSalaryByEmployNumber(employNumber);

        return EmployeeInfoEntity.builder()
                .employeeNumber(employeePO.getEmployeeNumber())
                .employeeName(employeePO.getEmployeeName())
                .employeeLevel(employeePO.getEmployeeLevel())
                .employeeTitle(employeePO.getEmployeeTitle())
                .salaryBaseAmount(employeeSalaryPO.getSalaryBaseAmount())
                .salaryMeritAmount(employeeSalaryPO.getSalaryMeritAmount())
                .salaryTotalAmount(employeeSalaryPO.getSalaryTotalAmount())
                .build();
    }
}
