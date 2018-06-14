package com.woostar.tender.web.service;

import com.woostar.tender.common.http.ServerResponse;

import javax.servlet.http.HttpServletResponse;

/**
 * @author huangs
 * @createtime 2018-06-05
 * @description
 */
public interface IProjectDetailService {

    /**
     * 招标项目信息分页搜索
     * @param pageNum 页码
     * @param pageSize 分页大小
     * @param searchCondition 搜索条件
     * @param searchContent 搜索条件内容
     * @param sortColumn 排序项
     * @param sortOrder 排序规则
     * @param announcementReleaseTime 公告发布时间
     * @param tenderDeadline 报名结束时间
     * @param filter 公告状态（报名中、已截止）
     * @return 搜索结果分页
     */
    ServerResponse searchList(int pageNum, int pageSize, String searchCondition, String searchContent, String sortColumn, String sortOrder, String announcementReleaseTime, String tenderDeadline, int filter);

    /**
     * 根据搜索条件显示搜索建议
     * @param searchCondition 搜索条件
     * @param searchContent 搜索内容
     * @return 搜索建议
     */
    ServerResponse searchRemote(String searchCondition, String searchContent);

    /**
     * 导出选中的项目信息至excel
     * @param response 服务器响应
     * @param projectIds 选中的项目id拼接的字符串
     */
    void exportExcel(HttpServletResponse response, String projectIds);
}
