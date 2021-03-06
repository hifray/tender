package com.woostar.tender.web.controller;

import com.woostar.tender.common.http.ServerResponse;
import com.woostar.tender.web.service.IProjectDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author huangs
 * @createtime 2018-06-04
 * @description 招标项目信息controller类
 */
@Controller
@RequestMapping("/tender")
public class ProjectDetailController extends BaseController {

    private final IProjectDetailService iProjectDetailService;

    @Autowired
    public ProjectDetailController(IProjectDetailService iProjectDetailService) {
        this.iProjectDetailService = iProjectDetailService;
    }


    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 招标项目信息分页搜索
     * @param pageNum 页码
     * @param pageSize 分页大小
     * @param searchCondition 搜索条件类别（报建名称、报建编号、招标项目名称、招标登记编号）
     * @param searchContent 搜索条件内容
     * @param sortColumn 排序项（tenderDeadline/createTime）
     * @param sortOrder 排序规则(asc/desc)
     * @param startDate 筛选开始日期
     * @param endDate 筛选结束日期
     * @return 搜索结果分页
     */
    @GetMapping("/list/search")
    @ResponseBody
    public ServerResponse searchList(@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                     @RequestParam(value = "searchCondition", required = false) String searchCondition,
                                     @RequestParam(value = "searchContent", required = false) String searchContent,
                                     @RequestParam(value = "sortColumn", required = false) String sortColumn,
                                     @RequestParam(value = "sortOrder", required = false) String sortOrder,
                                     @RequestParam(value = "startDate", required = false) String startDate,
                                     @RequestParam(value = "endDate", required = false) String endDate) {
        return iProjectDetailService.searchList(pageNum, pageSize, searchCondition, searchContent, sortColumn, sortOrder, startDate, endDate);
    }

    /**
     * 搜索项目时根据搜索条件显示搜索建议
     * @param searchCondition 搜索条件（报建名称、报建编号、招标项目名称、招标登记编号）
     * @param searchContent 搜索内容
     * @return 搜索建议
     */
    @GetMapping("/list/remote")
    @ResponseBody
    public ServerResponse searchRemote(@RequestParam("searchCondition") String searchCondition, @RequestParam("searchContent") String searchContent) {
        return iProjectDetailService.searchRemote(searchCondition, searchContent);
    }

    @RequestMapping("/list/excel")
    public void exportExcel(HttpServletResponse response, @RequestParam("projectIds") String projectIds) {
        iProjectDetailService.exportExcel(response, projectIds);
    }
}
