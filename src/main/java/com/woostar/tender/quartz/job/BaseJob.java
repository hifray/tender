package com.woostar.tender.quartz.job;

import com.woostar.tender.model.ProjectDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Class BaseJob Job基类
 *
 * @author huangshuo
 * Created on 2018-06-04
 */
public class BaseJob extends QuartzJobBean {

    /**
     * Field LOGGER 日志
     */
    static final Logger LOGGER = LoggerFactory.getLogger(ProjectDetail.class);

    /**
     * Method executeInternal 定时任务主方法
     *
     * @param jobExecutionContext of type JobExecutionContext
     * @throws JobExecutionException when 定时任务异常
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    }
}
