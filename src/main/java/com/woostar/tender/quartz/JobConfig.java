package com.woostar.tender.quartz;

import com.woostar.tender.quartz.job.BIDCHANCEJob;
import com.woostar.tender.quartz.job.WHZBTBJob;
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
         * Field WHZBTB_JOB WHZBTBJob执行周期
         */
        String PROJECT_JOB = "0 0 */4 * * ?";
        /**
         * Field SGCC_JOB SGCCJob执行周期
         */
        String SGCC_JOB = "0 0 */4 * * ?";

        /**
         * Field BIDCHANCE_JOB BIDCHANCEJob执行周期
         */
        String BIDCHANCE_JOB = "0 0 */4 * * ?";
    }

    /**
     * Interface JobIdentity
     *
     * 定时任务标识
     */
    private interface JobIdentity {
        /**
         * Field WHZBTB_JOB WHZBTBJob
         */
        String WHZBTB_JOB = "WHZBTB_JOB";
        /**
         * Field SGCC_JOB SGCCJob
         */
        String SGCC_JOB = "SGCC_JOB";

        /**
         * Field BIDCHANCE_JOB BIDCHANCEJob
         */
        String BIDCHANCE_JOB = "BIDCHANCE_JOB";
    }

    /**
     * Method whzbtbJobDetail
     * @return JobDetail
     */
    @Bean
    public JobDetail whzbtbJobDetail() {
        return JobBuilder.newJob(WHZBTBJob.class)
                .withIdentity(JobIdentity.WHZBTB_JOB)
                .storeDurably()
                .build();
    }

    /**
     * Method projectTaskTrigger
     * @return Trigger
     */
    @Bean
    public Trigger whzbtbTaskTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(CornSchedule.PROJECT_JOB);
        return TriggerBuilder.newTrigger()
                .forJob(whzbtbJobDetail())
                .withIdentity(JobIdentity.WHZBTB_JOB)
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

    /**
     * Method bidchanceJobDetail
     * @return JobDetail
     */
    @Bean
    public JobDetail bidchanceJobDetail() {
        return JobBuilder.newJob(BIDCHANCEJob.class)
                .withIdentity(JobIdentity.BIDCHANCE_JOB)
                .storeDurably()
                .build();
    }

    /**
     * Method bidchanceTaskTrigger
     * @return Trigger
     */
    @Bean
    public Trigger bidchanceTaskTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(CornSchedule.BIDCHANCE_JOB);
        return TriggerBuilder.newTrigger()
                .forJob(bidchanceJobDetail())
                .withIdentity(JobIdentity.BIDCHANCE_JOB)
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
