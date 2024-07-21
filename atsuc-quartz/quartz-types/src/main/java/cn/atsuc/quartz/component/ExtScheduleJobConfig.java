package cn.atsuc.quartz.component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author atsuc
 * @date 2024/7/4 21:26
 * @email s202011105851@163.com
 * @description
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtScheduleJobConfig {

    /**
     *  开关
     */
    boolean state() default true;

    /**
     *  任务名称
     */
    String jobName() default "缺省的";

    /**
     *  cron 表达式
     *  0/5：这是第一个字段（秒），表示从0秒开始，每隔5秒触发一次。
     *  *：第二个字段（分钟），表示每分钟都会触发。
     *  *：第三个字段（小时），表示每小时都会触发。
     *  *：第四个字段（日），表示每天都会触发。
     *  *：第五个字段（月），表示每月都会触发。
     *  ?：第六个字段（星期），在Quartz Scheduler中，日和星期这两个字段中至少有一个需要是?，因为这两个字段是互斥的，即你不能同时指定一个任务在每个月的特定日期和星期几执行。这里的?表示不指定星期几。
     */
    String cronExpression() default "0/1 * * * * ?";
}
