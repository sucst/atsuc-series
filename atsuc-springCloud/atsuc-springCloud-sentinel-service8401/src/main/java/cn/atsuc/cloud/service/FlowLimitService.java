package cn.atsuc.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author atsuc
 * @date 2024/7/18 20:14
 * @email s202011105851@163.com
 * @description
 */
@Service
public class FlowLimitService {

    @SentinelResource(value = "common")
    public void common() {
        System.out.println("------FlowLimitService come in");
    }
}
