package cn.atsuc.cloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author atsuc
 * @date 2024/7/20 18:57
 * @email s202011105851@163.com
 * @description
 */
public interface AccountService {


    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);

}
