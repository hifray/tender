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
 * @author huangs
 * @createtime 2018-06-05
 * @description
 */
@Component
public class ProjectDetailServiceImpl implements IProjectDetailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectDetailServiceImpl.class);

    private final IProjectDetailMapper iProjectDetailMapper;

    @Autowired
    public ProjectDetailServiceImpl(IProjectDetailMapper iProjectDetailMapper) {
        this.iProjectDetailMapper = iProjectDetailMapper;
    }

    @Override
    public ServerResponse searchList(int pageNum, int pageSize, String searchCondition, String searchContent, String sortColumn, String sortOrder, String announcementReleaseTime, String tenderDeadline, int filter) {
        ProjectDetailExample sqlExample = new ProjectDetailExample();
        ProjectDetailExample.Criteria criteria = sqlExample.createCriteria();
        // 条件搜索
        if (StringUtils.isNotEmpty(searchCondition) && StringUtils.isNotEmpty(searchContent)) {
            switch (searchCondition) {
                case "报建名称":
                    criteria.andReportNameLike('%'+ searchContent +'%');
                    break;
                case "报建编号":
                    criteria.andReportNumberLike('%'+ searchContent +'%');
                    break;
                case "招标项目名称":
                    criteria.andTenderProjectNameLike('%'+ searchContent +'%');
                    break;
                case "招标登记编号":
                    criteria.andTenderRegistrationNumberLike('%'+ searchContent +'%');
                    break;
                default:
                    // 表示无数据
                    criteria.andProjectIdIsNull();
                    break;
            }
        }
        // 公告发布时间
        if (StringUtils.isNotEmpty(announcementReleaseTime)) {
            criteria.andAnnouncementReleaseTimeLessThan(DateTimeUtil.stringToDate(announcementReleaseTime, DateTimeUtil.DEFAULT_FORMAT));
        }
        // 报名截止时间
        if (StringUtils.isNotEmpty(tenderDeadline)) {
            criteria.andTenderDeadlineLessThan(DateTimeUtil.stringToDate(tenderDeadline, DateTimeUtil.DEFAULT_FORMAT));
        }
        // 搜索结果排序
        if (StringUtils.isNotEmpty(sortColumn) && StringUtils.isNotEmpty(sortOrder)) {
            if (StringUtils.equals(sortOrder, "descending")) {
                sqlExample.orderBy(ProjectDetail.Column.valueOf(sortColumn).desc());
            }
            if (StringUtils.equals(sortOrder, "ascending")) {
                sqlExample.orderBy(ProjectDetail.Column.valueOf(sortColumn).asc());
            }
        }
        // 报名中
        if (filter == 1) {
            criteria.andTenderDeadlineGreaterThan(new Date());
        }
        // 已截止
        if (filter == 2) {
            criteria.andTenderDeadlineLessThan(new Date());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<ProjectDetail> projectDetailList = iProjectDetailMapper.selectByExample(sqlExample);
        PageInfo<ProjectDetail> pageInfo = new PageInfo<>(projectDetailList);
        return new ServerResponse.Builder<>(StatusCodeEnum.OK.getCode())
                .msg(StringUtils.EMPTY)
                .data(pageInfo)
                .build();
    }

    @Override
    public ServerResponse searchRemote(String searchCondition, String searchContent) {
        ProjectDetailExample sqlExample = new ProjectDetailExample();
        List<Map<String, String>> searchRemoteResultList = new ArrayList<>();
        if (StringUtils.equals(searchCondition, "报建名称") && StringUtils.isNotEmpty(searchContent)) {
            sqlExample.createCriteria().andReportNameLike('%'+ searchContent +'%');
            for (ProjectDetail projectDetail : iProjectDetailMapper.selectByExample(sqlExample)) {
                Map<String, String> map = new HashMap<>();
                map.put("value", projectDetail.getReportName());
                searchRemoteResultList.add(map);
            }
        }
        if (StringUtils.equals(searchCondition, "报建编号") && StringUtils.isNotEmpty(searchContent)) {
            sqlExample.createCriteria().andReportNumberLike('%'+ searchContent +'%');
            for (ProjectDetail projectDetail : iProjectDetailMapper.selectByExample(sqlExample)) {
                Map<String, String> map = new HashMap<>();
                map.put("value", projectDetail.getReportNumber());
                searchRemoteResultList.add(map);
            }
        }
        if (StringUtils.equals(searchCondition, "招标项目名称") && StringUtils.isNotEmpty(searchContent)) {
            sqlExample.createCriteria().andTenderProjectNameLike('%'+ searchContent +'%');
            for (ProjectDetail projectDetail : iProjectDetailMapper.selectByExample(sqlExample)) {
                Map<String, String> map = new HashMap<>();
                map.put("value", projectDetail.getTenderProjectName());
                searchRemoteResultList.add(map);
            }
        }
        if (StringUtils.equals(searchCondition, "招标登记编号") && StringUtils.isNotEmpty(searchContent)) {
            sqlExample.createCriteria().andTenderRegistrationNumberLike('%'+ searchContent +'%');
            for (ProjectDetail projectDetail : iProjectDetailMapper.selectByExample(sqlExample)) {
                Map<String, String> map = new HashMap<>();
                map.put("value", projectDetail.getTenderRegistrationNumber());
                searchRemoteResultList.add(map);
            }
        }
        return new ServerResponse.Builder<>(StatusCodeEnum.OK.getCode())
                .msg(StringUtils.EMPTY)
                .data(searchRemoteResultList)
                .build();
    }

    @Override
    public void exportExcel(HttpServletResponse response, String projectIds) {
        String[] projectIdList = projectIds.split(",");
        List<ProjectDetailExcel> list = new ArrayList<>();
        if (projectIdList.length > 0) {
            for (String projectId : projectIdList) {
                ProjectDetail projectDetail = iProjectDetailMapper.selectByPrimaryKey(projectId);
                ProjectDetailExcel projectDetailExcel = new ProjectDetailExcel();
                projectDetailExcel.setReportName(projectDetail.getReportName());
                projectDetailExcel.setReportNumber(projectDetail.getReportNumber());
                projectDetailExcel.setTenderProjectName(projectDetail.getTenderProjectName());
                projectDetailExcel.setTenderRegistrationNumber(projectDetail.getTenderRegistrationNumber());
                projectDetailExcel.setTenderProjectDescription(projectDetail.getTenderProjectDescription());
                projectDetailExcel.setTenderContactPerson(projectDetail.getTenderContactPerson());
                projectDetailExcel.setTenderContactPhone(projectDetail.getTenderContactPersonPhone());
                projectDetailExcel.setTenderProxyContactPerson(projectDetail.getTenderProxyContactPerson());
                projectDetailExcel.setTenderProxyContactPhone(projectDetail.getTenderProxyContactPersonPhone());
                projectDetailExcel.setTenderDeadline(projectDetail.getTenderDeadline());
                projectDetailExcel.setAnnouncementReleaseTime(projectDetail.getAnnouncementReleaseTime());
                projectDetailExcel.setRemark(projectDetail.getRemark());
                list.add(projectDetailExcel);
            }
        }
        // 创建excel文档
        HSSFWorkbook workbook = (HSSFWorkbook) ExcelExportUtil.exportExcel(new ExportParams("招投标项目信息", "招投标项目"), ProjectDetailExcel.class, list);
        // todo: 设置excel样式
        // 导出到excel文件
        String fileNameSuffix = DateTimeUtil.dateToString(new Date(), "yyyyMMddHHmmss");
        String fileName = "招标项目信息_"+ fileNameSuffix +".xls";
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode(fileName, "UTF-8"))));
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("文件编码格式不支持", e);
        }
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            LOGGER.error("excel文件导出错误", e);
        }
    }
}
