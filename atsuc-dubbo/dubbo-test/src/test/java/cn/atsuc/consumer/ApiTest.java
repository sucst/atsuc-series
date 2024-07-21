package cn.atsuc.consumer;


import cn.atsuc.dubbo.api.IUserService;
import cn.atsuc.dubbo.api.dto.UserReqDTO;
import cn.atsuc.dubbo.api.dto.UserResDTO;
import cn.atsuc.dubbo.api.types.Response;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author atsuc
 * @date 2024/6/27 22:48
 * @email s202011105851@163.com
 * @description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {
    // 测试使用直连模式；
    // @DubboReference(interfaceClass = IUserService.class, url = "dubbo://127.0.0.1:20881", version = "1.0.0")
    // 测试注册中心模式；需要配置 Zookeeper
    @DubboReference(interfaceClass = IUserService.class, version = "1.0.0")
    private IUserService userService;

    @Resource(name = "rpcProxyBeanFactory")
    private IUserService proxyUserService;

    @Test
    public void test_userService() {
        UserReqDTO reqDTO = UserReqDTO.builder().userId("10001").build();
        Response<UserResDTO> resDTO = userService.queryInfo(reqDTO);
        log.info("测试结果 req: {} res: {}", JSON.toJSONString(reqDTO), JSON.toJSONString(resDTO));
    }

    @Test
    public void test_proxyUserService(){
        UserReqDTO reqDTO = UserReqDTO.builder().userId("10001").build();
        Response<UserResDTO> resDTO = proxyUserService.queryInfo(reqDTO);
        log.info("测试结果 req: {} res: {}", JSON.toJSONString(reqDTO), JSON.toJSONString(resDTO));
    }

}
