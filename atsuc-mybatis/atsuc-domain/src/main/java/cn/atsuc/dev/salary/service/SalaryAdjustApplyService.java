package cn.atsuc.dev.salary.service;

import cn.atsuc.dev.salary.model.aggregate.AdjustSalaryApplyOrderAggregate;
import cn.atsuc.dev.salary.repository.ISalaryAdjustRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author atsuc
 * @date 2024/6/24 21:20
 * @email s202011105851@163.com
 * @description
 */
@Service
public class SalaryAdjustApplyService implements ISalaryAdjustApplyService {

    @Resource
    private ISalaryAdjustRepository salaryAdjustRepository;

    @Override
    public String adjustSalary(AdjustSalaryApplyOrderAggregate adjustSalaryApplyOrderAggregate) {
        return salaryAdjustRepository.adjustSalary(adjustSalaryApplyOrderAggregate);
    }
}
