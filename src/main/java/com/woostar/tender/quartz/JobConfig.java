package com.woostar.tender.quartz;

import com.woostar.tender.quartz.job.ProjectJob;
import com.woostar.tender.quartz.job.SGCCJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class JobConfig 定时任务配置类
 *
 * @author huangshuo
 * Created on 2018-06-01
 */
@Configuration
public class JobConfig {

    /**
     * Interface CornSchedule
     *
     * 定时任务Corn周期表达式
     */
    private interface CornSchedule {
        /**
         * Field PROJECT_JOB ProjectJob执行周期
         */
        String PROJECT_JOB = "0 0 */1 * * ?";
        /**
         * Field SGCC_JOB SGCCJob执行周期
         */
        String SGCC_JOB = "0 0 */1 * * ?";
    }

    /**
     * Interface JobIdentity
     *
     * 定时任务标识
     */
    private interface JobIdentity {
        /**
         * Field PROJECT_JOB ProjectJob
         */
        String PROJECT_JOB = "PROJECT_JOB";
        /**
         * Field SGCC_JOB SGCCJob
         */
        String SGCC_JOB = "SGCC_JOB";
    }

    /**
     * Method projectJobDetail
     * @return JobDetail
     */
    @Bean
    public JobDetail projectJobDetail() {
        return JobBuilder.newJob(ProjectJob.class)
                .withIdentity(JobIdentity.PROJECT_JOB)
                .storeDurably()
                .build();
    }

    /**
     * Method projectTaskTrigger
     * @return Trigger
     */
    @Bean
    public Trigger projectTaskTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(CornSchedule.PROJECT_JOB);
        return TriggerBuilder.newTrigger()
                .forJob(projectJobDetail())
                .withIdentity(JobIdentity.PROJECT_JOB)
                .withSchedule(cronScheduleBuilder)
                .build();
    }

    /**
     * Method sgccJobDetail
     * @return JobDetail
     */
    @Bean
    public JobDetail sgccJobDetail() {
        return JobBuilder.newJob(SGCCJob.class)
                .withIdentity(JobIdentity.SGCC_JOB)
                .storeDurably()
                .build();
    }

    /**
     * Method sgccTaskTrigger
     * @return Trigger
     */
    @Bean
    public Trigger sgccTaskTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(CornSchedule.SGCC_JOB);
        return TriggerBuilder.newTrigger()
                .forJob(sgccJobDetail())
                .withIdentity(JobIdentity.SGCC_JOB)
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
