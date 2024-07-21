package cn.atsuc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author atsuc
 * @date 2024/7/8 23:50
 * @email s202011105851@163.com
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main80 {

    public static void main(String[] args) {
        SpringApplication.run(Main80.class, args);
    }
}
