package cn.atsuc.controller;

import cn.atsuc.cloud.apis.PayFeignApi;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author atsuc
 * @date 2024/7/11 20:06
 * @email s202011105851@163.com
 * @description CircuitBreaker
 */
@RestController
public class OrderCircuitController {

    @Resource
    private PayFeignApi payFeignApi;

    /**
     *  circuit
     * @param id
     * @return
     */
    @GetMapping("/feign/pay/circuit/{id}")
    @CircuitBreaker(name = "cloud-payment-service", fallbackMethod = "myCircuitFallback")
    public String feignPayCircuit(@PathVariable("id") Integer id) {
        return payFeignApi.myCircuit(id);
    }

    // myCircuitFallback就是服务降级后的兜底处理方法
    public String myCircuitFallback(Integer id, Throwable throwable) {
        // 这里是容错处理逻辑，返回备用结果
        return "myCircuitFallback，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }

    /**
     * (船的)舱壁,隔离 Semaphore
     * @param id
     * @return
     */
    /*
        @GetMapping("/feign/pay/bulkhead/{id}")
        @Bulkhead(name = "cloud-payment-service", fallbackMethod = "myBulkheadFallback", type = Bulkhead.Type.SEMAPHORE)
        public String myBulkhead(@PathVariable("id") Integer id) {
            return payFeignApi.myBulkhead(id);
        }

        public String myBulkheadFallback(Integer id, Throwable throwable) {
            return "myBulkheadFallback，隔板超出最大数量限制，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
        }
    */

    /**
     *(船的)舱壁,隔离  threadPool
     * @param id
     * @return
     */
    @GetMapping(value = "/feign/pay/bulkhead/{id}")
    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "myBulkheadPoolFallback",type = Bulkhead.Type.THREADPOOL)
    public CompletableFuture<String> myBulkheadTheadPool(@PathVariable("id") Integer id) {
        System.out.println(Thread.currentThread().getName()+"\t"+"---开始进入");
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(Thread.currentThread().getName()+"\t"+"---准备离开");
        return CompletableFuture.supplyAsync(() -> payFeignApi.myBulkhead(id)+"\t"+"Bulkhead.Type.THREADPOOL");
    }
    public CompletableFuture<String> myBulkheadPoolFallback(Integer id,Throwable t) {
        return CompletableFuture.supplyAsync(() -> "Bulkhead.Type.THREADPOOL,系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~");
    }

    /**
     * ratelimit
     * @param id
     * @return
     */
    @GetMapping(value = "/feign/pay/ratelimit/{id}")
    @RateLimiter(name = "cloud-payment-service", fallbackMethod = "myRateLimiterFallback")
    public String myRateLimiterFallback(@PathVariable("id") Integer id) {
        return payFeignApi.myRateLimit(id);
    }

    public String myRateLimiterFallback(Integer id, Throwable throwable) {
        return "你被限流了，禁止访问/(ㄒoㄒ)/~~";
    }

}
