package com.woostar.tender.webmagic.pipeline;

import com.woostar.tender.mapper.ISGCCProjectDetailMapper;
import com.woostar.tender.model.SGCCProjectDetail;
import com.woostar.tender.webmagic.processor.SGCCPageProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Date;

/**
 * @author huangs
 * @createtime 2018-06-26
 * @description
 */
@Component
public class SGCCPipeline implements Pipeline {

    private final ISGCCProjectDetailMapper isgccProjectDetailMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(SGCCPipeline.class);

    @Autowired
    public SGCCPipeline(ISGCCProjectDetailMapper isgccProjectDetailMapper) {
        this.isgccProjectDetailMapper = isgccProjectDetailMapper;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        try {
            SGCCProjectDetail sgccProjectDetail = resultItems.get(SGCCPageProcessor.FIELD_KEY);
            if (sgccProjectDetail != null) {
                if (isgccProjectDetailMapper.selectByPrimaryKey(sgccProjectDetail.getProjectId()) == null) {
                    // 数据库中无此条记录时存储
                    sgccProjectDetail.setCreateTime(new Date());
                    isgccProjectDetailMapper.insert(sgccProjectDetail);
                } else {
                    // 数据库中存在此条记录则更新
                    sgccProjectDetail.setUpdateTime(new Date());
                    isgccProjectDetailMapper.updateByPrimaryKeySelective(sgccProjectDetail);
                }
            }
        } catch (Exception e) {
            LOGGER.error("数据存储异常" + e.getMessage(), e);
        }
    }
}
