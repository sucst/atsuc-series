package cn.atsuc.dev.salary.service;

import cn.atsuc.dev.salary.model.aggregate.AdjustSalaryApplyOrderAggregate;

/**
 * @author atsuc
 * @date 2024/6/24 21:20
 * @email s202011105851@163.com
 * @description
 */
public interface ISalaryAdjustApplyService {

    String adjustSalary(AdjustSalaryApplyOrderAggregate adjustSalaryApplyOrderAggregate);

}
