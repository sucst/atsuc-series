package cn.atsuc.cloud.component;

import cn.atsuc.cloud.apis.PayFeignSentinelApi;
import cn.atsuc.cloud.resp.ResultData;
import cn.atsuc.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * @author atsuc
 * @date 2024/7/18 22:52
 * @email s202011105851@163.com
 * @description
 */
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi {


    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),"对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}
