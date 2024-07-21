package cn.atsuc.quartz.component;

import lombok.Setter;

/**
 * @author atsuc
 * @date 2024/7/4 21:24
 * @email s202011105851@163.com
 * @description
 */
@Setter
public abstract class ExtScheduleJob implements Runnable {

    @Override
    public void run() {
        this.doJob();
    }

    protected abstract void doJob();
}
