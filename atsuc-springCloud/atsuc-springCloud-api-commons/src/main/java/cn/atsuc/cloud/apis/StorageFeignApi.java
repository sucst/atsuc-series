package cn.atsuc.cloud.apis;

import cn.atsuc.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author atsuc
 * @date 2024/7/20 16:33
 * @email s202011105851@163.com
 * @description 存储支付调用接口
 */
@FeignClient("seata-storage-service")
public interface StorageFeignApi {

    /**
     * 扣减库存操作
     * @param productId 订单id
     * @param count 库存数量
     * @return ResultData
     */
    @PostMapping("/storage/decrease")
    ResultData decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
