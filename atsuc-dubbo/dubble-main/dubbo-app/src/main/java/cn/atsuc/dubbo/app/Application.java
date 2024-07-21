package cn.atsuc.dubbo.app;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author atsuc
 * @date 2024/6/27 0:11
 * @email s202011105851@163.com
 * @description
 */
@SpringBootApplication
@Configurable
@EnableDubbo
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
