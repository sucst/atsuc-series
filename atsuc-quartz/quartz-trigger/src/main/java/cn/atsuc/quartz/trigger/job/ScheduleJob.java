package cn.atsuc.quartz.trigger.job;

import cn.atsuc.quartz.component.ExtScheduleJob;
import cn.atsuc.quartz.component.ExtScheduleJobConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author atsuc
 * @date 2024/7/4 21:46
 * @email s202011105851@163.com
 * @description
 */
@Slf4j
@Component()
@ExtScheduleJobConfig(state = false, jobName = "测试任务", cronExpression = "0/3 * * * * ?")
public class ScheduleJob extends ExtScheduleJob {

    @Override
    protected void doJob() {
        log.info(" Schedule - 01 测试任务 ");
    }
}
