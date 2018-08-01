package com.woostar.tender.web.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woostar.tender.common.excel.ProjectDetailExcel;
import com.woostar.tender.common.http.ServerResponse;
import com.woostar.tender.common.http.StatusCodeEnum;
import com.woostar.tender.common.util.DateTimeUtil;
import com.woostar.tender.mapper.IProjectDetailMapper;
import com.woostar.tender.model.ProjectDetail;
import com.woostar.tender.model.example.ProjectDetailExample;
import com.woostar.tender.web.service.IProjectDetailService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * Class ProjectDetailServiceImpl ProjectDetailService接口实现类
 *
 * @author huangshuo
 * Created on 2018-06-05
 */
@Component
public class ProjectDetailServiceImpl implements IProjectDetailService {

    /**
     * Field LOGGER 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectDetailServiceImpl.class);

    /**
     * Field iProjectDetailMapper 构造器注入
     */
    private final IProjectDetailMapper iProjectDetailMapper;

    /**
     * Constructor ProjectDetailServiceImpl creates a new ProjectDetailServiceImpl instance.
     *
     * @param iProjectDetailMapper of type IProjectDetailMapper
     */
    @Autowired
    public ProjectDetailServiceImpl(IProjectDetailMapper iProjectDetailMapper) {
        this.iProjectDetailMapper = iProjectDetailMapper;
    }

    /**
     * Method searchList 搜索项目信息
     *
     * @param pageNum of type int 页码
     * @param pageSize of type int 分页大小
     * @param searchContent of type String 搜索内容
     * @param announceStatus of type int 公告状态
     * @param sourceWebsite of type int 来源网站
     * @param releaseTime of type String 公告发布时间
     * @param deadline of type String 公告截止时间
     * @return ServerResponse<PageInfo < ProjectDetail>>
     */
    @Override
    public ServerResponse<PageInfo<ProjectDetail>> searchList(int pageNum, int pageSize, String searchContent, int announceStatus, int sourceWebsite, String releaseTime, String deadline) {
        return null;
    }

    /**
     * Method searchAutoComplete 自动补全搜索内容
     *
     * @param searchContent of type String 搜索内容
     * @return ServerResponse<List < Map < String ,   String>>>
     */
    @Override
    public ServerResponse<List<Map<String, String>>> searchAutoComplete(String searchContent) {
        ProjectDetailExample sqlExample = new ProjectDetailExample();
        List<Map<String, String>> searchRemoteResultList = new ArrayList<>();
        if (StringUtils.isNotEmpty(searchContent)) {
            sqlExample.createCriteria().andProjectNameLike('%'+ searchContent +'%');
            for (ProjectDetail projectDetail : iProjectDetailMapper.selectByExample(sqlExample)) {
                Map<String, String> map = new HashMap<>(16);
                map.put("value", projectDetail.getProjectName());
                searchRemoteResultList.add(map);
            }
        }
        return new ServerResponse.Builder<List<Map<String, String>>>(StatusCodeEnum.OK.getCode())
                .msg(StringUtils.EMPTY)
                .data(searchRemoteResultList)
                .build();
    }

    /**
     * Method exportExcel 导出项目信息至Excel
     *
     * @param response of type HttpServletResponse
     * @param projectIds of type String
     */
    @Override
    public void exportExcel(HttpServletResponse response, String projectIds) {
//        String[] projectIdList = projectIds.split(",");
//        List<ProjectDetailExcel> list = new ArrayList<>();
//        if (projectIdList.length > 0) {
//            for (String projectId : projectIdList) {
//                ProjectDetail projectDetail = iProjectDetailMapper.selectByPrimaryKey(projectId);
//                ProjectDetailExcel projectDetailExcel = new ProjectDetailExcel();
//                projectDetailExcel.setReportName(projectDetail.getReportName());
//                projectDetailExcel.setReportNumber(projectDetail.getReportNumber());
//                projectDetailExcel.setTenderProjectName(projectDetail.getTenderProjectName());
//                projectDetailExcel.setTenderRegistrationNumber(projectDetail.getTenderRegistrationNumber());
//                projectDetailExcel.setTenderProjectDescription(projectDetail.getTenderProjectDescription());
//                projectDetailExcel.setTenderContactPerson(projectDetail.getTenderContactPerson());
//                projectDetailExcel.setTenderContactPhone(projectDetail.getTenderContactPersonPhone());
//                projectDetailExcel.setTenderProxyContactPerson(projectDetail.getTenderProxyContactPerson());
//                projectDetailExcel.setTenderProxyContactPhone(projectDetail.getTenderProxyContactPersonPhone());
//                projectDetailExcel.setTenderDeadline(projectDetail.getTenderDeadline());
//                projectDetailExcel.setAnnouncementReleaseTime(projectDetail.getAnnouncementReleaseTime());
//                projectDetailExcel.setRemark(projectDetail.getRemark());
//                list.add(projectDetailExcel);
//            }
//        }
//        // 创建excel文档
//        HSSFWorkbook workbook = (HSSFWorkbook) ExcelExportUtil.exportExcel(new ExportParams("招投标项目信息", "招投标项目"), ProjectDetailExcel.class, list);
//        // todo: 设置excel样式
//        // 导出到excel文件
//        String fileNameSuffix = DateTimeUtil.dateToString(new Date(), "yyyyMMddHHmmss");
//        String fileName = "招标项目信息_"+ fileNameSuffix +".xls";
//        response.setContentType("application/ms-excel;charset=UTF-8");
//        try {
//            response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode(fileName, "UTF-8"))));
//        } catch (UnsupportedEncodingException e) {
//            LOGGER.error("文件编码格式不支持", e);
//        }
//        try {
//            workbook.write(response.getOutputStream());
//        } catch (IOException e) {
//            LOGGER.error("excel文件导出错误", e);
//        }
    }
}
