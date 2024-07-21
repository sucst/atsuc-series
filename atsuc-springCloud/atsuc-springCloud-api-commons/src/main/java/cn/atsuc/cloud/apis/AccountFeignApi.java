package cn.atsuc.cloud.apis;

import cn.atsuc.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author atsuc
 * @date 2024/7/20 16:38
 * @email s202011105851@163.com
 * @description 支付账户扣减操作
 */
@FeignClient("seata-account-service")
public interface AccountFeignApi {

    /**
     * 账户扣减操作
     * @param userId 用户id
     * @param money 余额
     * @return ResultData
     */
    @PostMapping("/account/decrease")
    ResultData decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
