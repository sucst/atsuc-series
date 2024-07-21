package cn.atsuc.cloud.apis;

import cn.atsuc.cloud.component.PayFeignSentinelApiFallBack;
import cn.atsuc.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author atsuc
 * @date 2024/7/18 22:50
 * @email s202011105851@163.com
 * @description
 */
@FeignClient(value = "nacos-payment-provider", fallback = PayFeignSentinelApiFallBack.class)
public interface PayFeignSentinelApi {

    @GetMapping("/pay/nacos/get/{orderNo}")
    ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo);
}
