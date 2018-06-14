package com.woostar.tender.webmagic.pipeline;

import com.woostar.tender.mapper.IProjectDetailMapper;
import com.woostar.tender.model.ProjectDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;

import java.util.Date;

/**
 * @author huangs
 * @createtime 2018-06-01
 * @description
 */
@Component
public class ProjectPipeline extends BasePipeline {
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
            ProjectDetail projectDetail = resultItems.get("projectDetail");
            if (projectDetail != null) {
                if (iProjectDetailMapper.selectByPrimaryKey(projectDetail.getProjectId()) == null) {
                    // 数据库中无此条记录时存储
                    projectDetail.setCreateTime(new Date());
                    iProjectDetailMapper.insert(projectDetail);
                } else {
                    // 数据库中存在此条记录则更新
                    projectDetail.setUpdateTime(new Date());
                    iProjectDetailMapper.updateByPrimaryKeySelective(projectDetail);
                }
            }
        } catch (Exception e) {
            LOGGER.error("数据存储异常" + e.getMessage(), e);
        }
    }
}
