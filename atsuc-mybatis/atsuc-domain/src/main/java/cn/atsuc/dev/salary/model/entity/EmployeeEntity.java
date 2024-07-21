package cn.atsuc.dev.salary.model.entity;

import cn.atsuc.dev.salary.model.valobj.EmployeePostVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atsuc
 * @date 2024/6/24 21:15
 * @email s202011105851@163.com
 * @description 雇员实体对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    /** 雇员级别 */
    private EmployeePostVO employeeLevel;
    /** 雇员岗位Title */
    private EmployeePostVO employeeTitle;

}
