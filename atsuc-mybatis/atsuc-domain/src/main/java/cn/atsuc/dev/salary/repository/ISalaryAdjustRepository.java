package cn.atsuc.dev.salary.repository;

import cn.atsuc.dev.salary.model.aggregate.AdjustSalaryApplyOrderAggregate;

/**
 * @author atsuc
 * @date 2024/6/24 21:19
 * @email s202011105851@163.com
 * @description
 */
public interface ISalaryAdjustRepository {

    String adjustSalary(AdjustSalaryApplyOrderAggregate adjustSalaryApplyOrderAggregate);

}
