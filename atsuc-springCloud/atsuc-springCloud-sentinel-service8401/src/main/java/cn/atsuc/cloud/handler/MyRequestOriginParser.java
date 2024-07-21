package cn.atsuc.cloud.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * @author atsuc
 * @date 2024/7/18 22:25
 * @email s202011105851@163.com
 * @description 名单限制
 */
@Component
public class MyRequestOriginParser implements RequestOriginParser {


    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getParameter("serverName");
    }
}
