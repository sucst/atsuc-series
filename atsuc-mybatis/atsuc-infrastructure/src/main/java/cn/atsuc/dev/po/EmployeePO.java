package cn.atsuc.dev.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author atsuc
 * @date 2024/6/24 21:26
 * @email s202011105851@163.co
 * @description 雇员表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePO {
    /** 自增ID */
    private Long id;
    /** 雇员编号 */
    private String employeeNumber;
    /** 雇员姓名 */
    private String employeeName;
    /** 雇员级别 */
    private String employeeLevel;
    /** 雇员岗位Title */
    private String employeeTitle;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

}
