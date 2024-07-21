package cn.atsuc.quartz.trigger.job;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author atsuc
 * @date 2024/7/4 21:33
 * @email s202011105851@163.com
 * @description
 */
@Slf4j
@Component
public class QuartzJob {

    @Scheduled(cron = "0/3 * * * * ?")
    public void executeScheduled() {
        log.info(" Quartz - 01 ");
    }

    @Scheduled(cron = "0/3 * * * * ?")
    public void executeScheduled2() {
        log.info(" Quartz - 02 ");
    }
}
