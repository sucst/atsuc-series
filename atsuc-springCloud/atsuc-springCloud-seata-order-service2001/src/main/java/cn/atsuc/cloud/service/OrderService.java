package cn.atsuc.cloud.service;

import cn.atsuc.cloud.entities.Order;

/**
 * @author atsuc
 * @date 2024/7/20 17:47
 * @email s202011105851@163.com
 * @description 订单服务接口
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order
     */
    void createOrder(Order order);
}
