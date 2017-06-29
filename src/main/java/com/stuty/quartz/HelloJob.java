package com.stuty.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017-6-29.
 */
public class HelloJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date now = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(now));

        System.out.println("Hello World!");
    }
}
