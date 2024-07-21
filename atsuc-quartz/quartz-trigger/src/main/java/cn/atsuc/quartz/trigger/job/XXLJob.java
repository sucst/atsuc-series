package cn.atsuc.quartz.trigger.job;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author atsuc
 * @date 2024/7/4 21:49
 * @email s202011105851@163.com
 * @description
 */
@Slf4j
@Component
public class XXLJob {

    @XxlJob("demoJobHandler")
    public void doJob(){
        log.info(" xxl-job 001 ");
    }
}
