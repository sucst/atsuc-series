package cn.atsuc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author atsuc
 * @date 2024/7/8 21:30
 * @email s202011105851@163.com
 * @description
 */
@SpringBootApplication
@MapperScan("cn.atsuc.cloud.mapper")
@EnableDiscoveryClient
@RefreshScope // 动态刷新
public class Main8002 {
    public static void main(String[] args) {
        SpringApplication.run(Main8002.class, args);
    }
}
