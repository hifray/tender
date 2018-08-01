package com.woostar.tender.quartz.job;

import com.woostar.tender.common.util.DateTimeUtil;
import com.woostar.tender.webmagic.pipeline.ProjectPipeline;
import com.woostar.tender.webmagic.processor.ProjectPageProcessor;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.Spider;

/**
 * Class ProjectJob
 *
 * @author huangshuo
 * Created on 2018-06-01
 */
public class ProjectJob extends BaseJob {

    /**
     * Field projectPipeline
     * 注入ProjectPipeline(Job类必须有默认的无参构造器，因而此处不可用构造器注入，否则Job将无法实例化)
     */
    @Autowired
    private ProjectPipeline projectPipeline;

    /**
     * Method executeInternal 定时任务主方法
     *
     * @param jobExecutionContext of type JobExecutionContext
     * @throws JobExecutionException when 定时任务异常
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.info("定时任务已启动("+ DateTimeUtil.dateToString(jobExecutionContext.getFireTime(), DateTimeUtil.DEFAULT_FORMAT) +")");
        try {
            Spider.create(new ProjectPageProcessor())
                    .addUrl(ProjectPageProcessor.LIST_URL + ProjectPageProcessor.DETAIL_URL_PARAMETER)
                    .addPipeline(projectPipeline)
                    .thread(5)
                    .setExitWhenComplete(true)
                    .run();
        } catch (Exception e) {
            LOGGER.error("定时任务执行异常" + e.getMessage(), e);
        }
        LOGGER.info("定时任务已结束。下次启动时间为("+ DateTimeUtil.dateToString(jobExecutionContext.getNextFireTime(), DateTimeUtil.DEFAULT_FORMAT) +")");
    }
}
