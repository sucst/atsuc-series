package cn.atsuc.cloud.service;

import cn.atsuc.cloud.entities.Pay;

import java.util.List;

/**
 * @author atsuc
 * @date 2024/7/8 21:50
 * @email s202011105851@163.com
 * @description 支付服务
 */
public interface PayService {

    int add(Pay pay);
    int delPay(Integer id);
    int updatePay(Pay pay);
    Pay getById(Integer id);
    List<Pay> getAll();
}
