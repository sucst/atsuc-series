package cn.atsuc.cloud.service.impl;

import cn.atsuc.cloud.apis.AccountFeignApi;
import cn.atsuc.cloud.apis.StorageFeignApi;
import cn.atsuc.cloud.entities.Order;
import cn.atsuc.cloud.mapper.OrderMapper;
import cn.atsuc.cloud.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author atsuc
 * @date 2024/7/20 17:48
 * @email s202011105851@163.com
 * @description 订单服务 下订单->减库存->扣余额->改(订单)状态
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    /** 订单微服务通过OpenFeign去调用库存微服务 */
    @Resource
    private StorageFeignApi storageFeignApi;
    /** 订单微服务通过OpenFeign去调用账户微服务 */
    @Resource
    private AccountFeignApi accountFeignApi;

    @Override
    @GlobalTransactional(name = "atsuc-create-order",rollbackFor = Exception.class) //AT
    public void createOrder(Order order) {
        // xid检查
        String xid = RootContext.getXID();
        // 1.新建订单
        log.info("==================>开始新建订单"+"\t"+"xid_order:" +xid);
        // 订单状态 status: 0 创建中； 1:已完结
        order.setStatus(0);
        int result = orderMapper.insertSelective(order);
        // 插入订单成功后获得插入mssql的实体对象
        Order orderFromDB = null;

        if (result > 0) {
            orderFromDB = orderMapper.selectOne(order);
            log.info("-------> 新建订单成功，orderFromDB info: "+orderFromDB);
            System.out.println();
            //2. 扣减库存
            log.info("-------> 订单微服务开始调用Storage库存，做扣减count");
            storageFeignApi.decrease(orderFromDB.getProductId(), orderFromDB.getCount());
            log.info("-------> 订单微服务结束调用Storage库存，做扣减完成");
            System.out.println();
            // 3.扣减账号余额
            log.info("-------> 订单微服务开始调用Account账号，做扣减money");
            accountFeignApi.decrease(orderFromDB.getUserId(), orderFromDB.getMoney());
            log.info("-------> 订单微服务结束调用Account账号，做扣减完成");
            System.out.println();
            // 修改状态
            log.info("-------> 修改订单状态");
            orderFromDB.setStatus(1);

            Example whereCondition = new Example(Order.class);
            Example.Criteria criteria = whereCondition.createCriteria();
            criteria.andEqualTo("userId", orderFromDB.getUserId());
            criteria.andEqualTo("status", 0);

            int updateResult = orderMapper.updateByExample(orderFromDB, whereCondition);

            log.info("-------> 修改订单状态完成"+"\t"+updateResult);
            log.info("-------> orderFromDB info: "+orderFromDB);
        }
        System.out.println();
        log.info("==================>结束新建订单"+"\t"+"xid_order:" +xid);
    }
}
