package com.woostar.tender.web.controller;

import com.github.pagehelper.PageInfo;
import com.woostar.tender.common.http.ServerResponse;
import com.woostar.tender.model.ProjectDetail;
import com.woostar.tender.web.service.IProjectDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Class ProjectDetailController
 *
 * @author huangshuo
 * Created on 2018-06-24
 */
@Controller
@RequestMapping("/tender")
public class ProjectDetailController{

    /**
     * Field iProjectDetailService 构造器注入
     */
    private final IProjectDetailService iProjectDetailService;

    /**
     * Constructor ProjectDetailController creates a new ProjectDetailController instance.
     *
     * @param iProjectDetailService of type IProjectDetailService
     */
    @Autowired
    public ProjectDetailController(IProjectDetailService iProjectDetailService) {
        this.iProjectDetailService = iProjectDetailService;
    }

    /**
     * Method index 首页
     * @return String
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
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
    @GetMapping("/list/search")
    @ResponseBody
    public ServerResponse<PageInfo<ProjectDetail>> searchList(@RequestParam(value = "pageNum", required = false, defaultValue = "1")int pageNum,
                                                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                                              @RequestParam(value = "searchContent", required = false) String searchContent,
                                                              @RequestParam(value = "announceStatus", required = false, defaultValue = "3") int announceStatus,
                                                              @RequestParam(value = "sourceWebsite", required = false, defaultValue = "6") int sourceWebsite,
                                                              @RequestParam(value = "releaseTime", required = false) String releaseTime,
                                                              @RequestParam(value = "deadline", required = false) String deadline) {
        return iProjectDetailService.searchList(pageNum, pageSize, searchContent, announceStatus, sourceWebsite, releaseTime, deadline);
    }

    /**
     * Method searchAutoComplete 自动补全搜索内容
     *
     * @param searchContent of type String 搜索内容
     * @return ServerResponse<List < Map < String ,   String>>>
     */
    @GetMapping("/list/search/auto_complete")
    @ResponseBody
    public ServerResponse<List<Map<String,String>>> searchAutoComplete(@RequestParam("searchContent") String searchContent) {
        return iProjectDetailService.searchAutoComplete(searchContent);
    }

    /**
     * Method exportExcel 导出项目信息至Excel
     *
     * @param response of type HttpServletResponse
     * @param projectIds of type String
     */
    @RequestMapping("/list/excel")
    public void exportExcel(HttpServletResponse response, @RequestParam("projectIds") String projectIds) {
        iProjectDetailService.exportExcel(response, projectIds);
    }
}
