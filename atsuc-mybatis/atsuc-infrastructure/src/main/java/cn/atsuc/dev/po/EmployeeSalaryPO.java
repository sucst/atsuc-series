package cn.atsuc.dev.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author atsuc
 * @date 2024/6/24 21:28
 * @email s202011105851@163.com
 * @description 雇员薪资表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSalaryPO {
    /** 自增ID */
    private Long id;
    /** 雇员编号 */
    private String employeeNumber;
    /** 薪资总额 */
    private BigDecimal salaryTotalAmount;
    /** 绩效工资 */
    private BigDecimal salaryMeritAmount;
    /** 基础工资 */
    private BigDecimal salaryBaseAmount;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;



}
