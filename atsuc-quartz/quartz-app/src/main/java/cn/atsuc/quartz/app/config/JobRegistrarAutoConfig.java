package cn.atsuc.quartz.app.config;


import cn.atsuc.quartz.component.ExtScheduleJobConfig;
import cn.atsuc.quartz.component.ExtScheduleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.Collection;
import java.util.Map;

/**
 * @author atsuc
 * @date 2024/7/4 21:52
 * @email s202011105851@163.com
 * @description
 */
@Slf4j
@Configuration
@EnableScheduling
public class JobRegistrarAutoConfig implements SchedulingConfigurer {

    private final ApplicationContext applicationContext;

    public JobRegistrarAutoConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        Map<String, ExtScheduleJob> jobBeanMap = applicationContext.getBeansOfType(ExtScheduleJob.class);
        Collection<ExtScheduleJob> jobBeans = jobBeanMap.values();
        for (ExtScheduleJob ExtScheduleJob : jobBeans) {
            ExtScheduleJobConfig extScheduleJobConfig = AnnotationUtils.findAnnotation(ExtScheduleJob.getClass(), ExtScheduleJobConfig.class);
            if (null == extScheduleJobConfig || !extScheduleJobConfig.state()) continue;
            log.info(" task start {} {}", extScheduleJobConfig.jobName(), extScheduleJobConfig.cronExpression());
            taskRegistrar.addCronTask(ExtScheduleJob, extScheduleJobConfig.cronExpression());
        }
    }
}
