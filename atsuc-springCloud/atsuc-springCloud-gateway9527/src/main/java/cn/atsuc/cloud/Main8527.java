package cn.atsuc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //服务注册和发现
public class Main8527 {

   public static void main(String[] args) {
      SpringApplication.run(Main8527.class, args);
   }
}