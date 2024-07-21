package cn.atsuc.cloud.service.impl;

import cn.atsuc.cloud.entities.Pay;
import cn.atsuc.cloud.mapper.PayMapper;
import cn.atsuc.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author atsuc
 * @date 2024/7/8 21:52
 * @email s202011105851@163.com
 * @description 支付实现
 */
@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper;

    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delPay(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updatePay(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
