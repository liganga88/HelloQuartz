package com.stuty.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017-6-29.
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        //创建一个JobDetail实例
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myJob","group1")
                .usingJobData("message", "helloJob")
                .usingJobData("jobFloat", 3.14f)
                .build();
        //创建一个Trigger实例
        CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * 14,17 * * ?"))
                .build();
        //创建scheduler实例
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();

        Date now = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(now));

        scheduler.scheduleJob(jobDetail,trigger);
    }
}
