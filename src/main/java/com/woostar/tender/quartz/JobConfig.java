package com.woostar.tender.quartz;

import com.woostar.tender.quartz.job.ProjectJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangs
 * @createtime 2018-06-01
 * @description Job配置类
 */
@Configuration
public class JobConfig {

    /**
     * 任务定时周期Corn表达式
     */
    private interface CornSchedule {
        String PROJECT_JOB = "0 0 */1 * * ?";
    }

    /**
     * JobIdentity
     */
    private interface JobIdentity {
        String PROJECT_JOB = "PROJECT_JOB";
    }

    @Bean
    public JobDetail projectJobDetail() {
        return JobBuilder.newJob(ProjectJob.class)
                .withIdentity(JobIdentity.PROJECT_JOB)
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger projectTaskTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(CornSchedule.PROJECT_JOB);
        return TriggerBuilder.newTrigger()
                .forJob(projectJobDetail())
                .withIdentity(JobIdentity.PROJECT_JOB)
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
