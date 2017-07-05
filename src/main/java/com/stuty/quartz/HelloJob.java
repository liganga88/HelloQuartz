package com.stuty.quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017-6-29.
 */
public class HelloJob implements Job {

    private String message;
    private float jobFloat;
    private double trDouble;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public float getJobFloat() {
        return jobFloat;
    }

    public void setJobFloat(float jobFloat) {
        this.jobFloat = jobFloat;
    }

    public double getTrDouble() {
        return trDouble;
    }

    public void setTrDouble(double trDouble) {
        this.trDouble = trDouble;
    }

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date now = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(now));

        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println("job" + jobKey.getName() + "," + jobKey.getGroup());

        JobKey jobKey2 = jobExecutionContext.getTrigger().getJobKey();
        System.out.println("job2" + jobKey2.getName() + "," + jobKey2.getGroup());

        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        System.out.println("trigger" + triggerKey.getName() + "," + triggerKey.getGroup());

/*        JobDataMap jobMap = jobExecutionContext.getJobDetail().getJobDataMap();
        JobDataMap triggerMap = jobExecutionContext.getTrigger().getJobDataMap();
        String jobMsg = jobMap.getString("message");
        float jobFloat = jobMap.getFloat("jobFloat");

        String trMsg = triggerMap.getString("message");
        double trDouble = triggerMap.getDouble("trDouble");
        System.out.println("jobContext:" + jobMsg + "," + jobFloat);
        System.out.println("triggerContext:" + trMsg + "," + trDouble);
        */

        System.out.println("jobContext:" + message + "," + jobFloat + "," + trDouble);
    }
}
