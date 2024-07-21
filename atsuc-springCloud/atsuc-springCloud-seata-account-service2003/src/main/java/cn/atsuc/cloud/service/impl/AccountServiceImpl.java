package cn.atsuc.cloud.service.impl;

import cn.atsuc.cloud.mapper.AccountMapper;
import cn.atsuc.cloud.service.AccountService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author atsuc
 * @date 2024/7/20 18:58
 * @email s202011105851@163.com
 * @description
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    /**
     *  扣减账户余额
     * @param userId 用户id
     * @param money 本次消费金额
     */
    @Override
    public void decrease(Long userId, Long money) {
        log.info("------->account-service中扣减账户余额开始");
        accountMapper.decrease(userId, money);
        myTimeOut();
        //int age = 10/0;
        log.info("------->account-service中扣减账户余额结束");
    }
    /**
     * 模拟超时异常，全局事务回滚
     */
    private static void myTimeOut() {
        try { TimeUnit.SECONDS.sleep(65); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }

}
