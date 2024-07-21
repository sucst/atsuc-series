package cn.atsuc.dev.config;

import cn.atsuc.dev.plugin.FieldEncryptionAndDecryptionMybatisPlugin;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author atsuc
 * @date 2024/6/24 22:28
 * @email s202011105851@163.com
 * @description
 */
@Configuration
public class PluginAutoConfiguration {

    @Bean
    public Interceptor plugin() {
        return new FieldEncryptionAndDecryptionMybatisPlugin();
    }
}
