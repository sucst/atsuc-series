package cn.atsuc.cloud.controller;

import cn.atsuc.cloud.entities.Order;
import cn.atsuc.cloud.resp.ResultData;
import cn.atsuc.cloud.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author atsuc
 * @date 2024/7/20 18:01
 * @email s202011105851@163.com
 * @description 订单控制
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public ResultData create(Order order) {
        orderService.createOrder(order);
        return ResultData.success(order);
    }
}
