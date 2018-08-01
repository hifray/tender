package com.woostar.tender.web.service;

import com.github.pagehelper.PageInfo;
import com.woostar.tender.common.http.ServerResponse;
import com.woostar.tender.model.ProjectDetail;

import java.util.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Interface IProjectDetailService
 *
 * @author huangshuo
 * Created on 2018-06-05
 */
public interface IProjectDetailService {

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
    ServerResponse<PageInfo<ProjectDetail>> searchList(int pageNum, int pageSize, String searchContent, int announceStatus, int sourceWebsite, String releaseTime, String deadline);

    /**
     * Method searchAutoComplete 自动补全搜索内容
     *
     * @param searchContent of type String 搜索内容
     * @return ServerResponse<List < Map < String ,   String>>>
     */
    ServerResponse<List<Map<String, String>>> searchAutoComplete(String searchContent);

    /**
     * Method exportExcel 导出项目信息至Excel
     *
     * @param response of type HttpServletResponse
     * @param projectIds of type String
     */
    void exportExcel(HttpServletResponse response, String projectIds);
}
