package cn.atsuc.dev.salary.model.aggregate;

import cn.atsuc.dev.salary.model.entity.EmployeeEntity;
import cn.atsuc.dev.salary.model.entity.EmployeeSalaryAdjustEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atsuc
 * @date 2024/6/24 21:14
 * @email s202011105851@163.com
 * @description 调薪受理单聚合对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdjustSalaryApplyOrderAggregate {
    /** 雇员编号 */
    private String employeeNumber;
    /** 调薪单号 */
    private String orderId;
    /** 雇员实体 */
    private EmployeeEntity employeeEntity;
    /** 雇员实体 */
    private EmployeeSalaryAdjustEntity employeeSalaryAdjustEntity;

}
