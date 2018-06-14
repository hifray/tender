package com.woostar.tender.quartz.job;

import com.woostar.tender.model.ProjectDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author huangs
 * @createtime 2018-06-04
 * @description
 */
public class BaseJob extends QuartzJobBean {

    protected static final Logger LOGGER = LoggerFactory.getLogger(ProjectDetail.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    }
}
