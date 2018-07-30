package com.woostar.tender.webmagic.pipeline;

import com.woostar.tender.mapper.IProjectDetailMapper;
import com.woostar.tender.model.ProjectDetail;
import com.woostar.tender.model.example.ProjectDetailExample;
import com.woostar.tender.webmagic.processor.BasePageProcessor;
import com.woostar.tender.webmagic.processor.ProjectPageProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Date;
import java.util.List;

/**
 * @author huangs
 * @createtime 2018-06-01
 * @description
 */
@Component
public class ProjectPipeline implements Pipeline {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectPipeline.class);
    /**
     * 注入IProjectDetailDao
     */
    private final IProjectDetailMapper iProjectDetailMapper;

    @Autowired
    public ProjectPipeline(IProjectDetailMapper iProjectDetailMapper) {
        this.iProjectDetailMapper = iProjectDetailMapper;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        try {
            ProjectDetail projectDetail = resultItems.get(BasePageProcessor.FIELD_KEY);
            if (projectDetail != null) {
                ProjectDetailExample sqlExample = new ProjectDetailExample();
                sqlExample.createCriteria().andProjectIdEqualTo(projectDetail.getProjectId());
                if (iProjectDetailMapper.selectByExample(sqlExample).size() == 0) {
                    // 数据库中无此条记录时存储
                    projectDetail.setCreateTime(new Date());
                    iProjectDetailMapper.insert(projectDetail);
                } else {
                    // 数据库中存在此条记录则更新
                    projectDetail.setUpdateTime(new Date());
                    iProjectDetailMapper.updateByExampleSelective(projectDetail, sqlExample);
                }
            }
        } catch (Exception e) {
            LOGGER.error("数据存储异常" + e.getMessage(), e);
        }
    }
}
