package cn.atsuc.dev.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author atsuc
 * @date 2024/6/24 21:27
 * @email s202011105851@163.com
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSalaryAdjustPO {
    /** 自增ID */
    private Long id;
    /** 雇员编号 */
    private String employeeNumber;
    /** 调薪单号 */
    private String adjustOrderId;
    /** 总额调薪 */
    private BigDecimal adjustTotalAmount;
    /** 基础调薪 */
    private BigDecimal adjustBaseAmount;
    /** 绩效调薪 */
    private BigDecimal adjustMeritAmount;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

}
