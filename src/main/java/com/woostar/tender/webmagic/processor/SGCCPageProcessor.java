package com.woostar.tender.webmagic.processor;

import com.woostar.tender.common.constant.WebsiteEnum;
import com.woostar.tender.common.util.DateTimeUtil;
import com.woostar.tender.model.ProjectDetail;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.selector.Selectable;

import java.util.Date;
import java.util.List;

/**
 * Class SGCCPageProcessor 国家电网电子商务平台PageProcessor类
 *
 * @author huangshuo
 * Created on 2018-06-26
 */
public class SGCCPageProcessor extends BasePageProcessor {

    /**
     * Field LIST_URL 爬虫初始请求地址
     */
    public static final String LIST_URL = "http://ecp.sgcc.com.cn/topic_project_list.jsp?";

    /**
     * Field LIST_URL_PARAMETERS 项目信息参数
     */
    public static final String LIST_URL_PARAMETERS = "company_id=00&status=2";

    /**
     * Method process 爬虫主方法
     *
     * @param page of type Page
     */
    @Override
    public void process(Page page) {
        try {
            if (page.getUrl().regex(LIST_URL + "\\w+").match()) {
                // 获取项目详情链接
                List<Selectable> selectableList = page.getHtml().xpath("//td[@class='black40']/a").nodes();
                for (Selectable selectable : selectableList) {
                    String column = selectable.regex("'(.*)',").toString().trim();
                    String projectId = selectable.regex(",'(.*)'").toString().trim();
                    // 添加项目详情链接至请求队列
                    page.addTargetRequest("http://ecp.sgcc.com.cn/html/project/"+ column +"/"+ projectId +".html");
                }
            } else {
                ProjectDetail projectDetail = new ProjectDetail();
                List<Selectable> projectDetails = page.getHtml().xpath("//tbody/tr/td").nodes();
                // 页面有无报名截止日期
                int offsetIndex = projectDetails.size() == 34 ? 2 : 0;
                // 获取项目信息
                String projectId = getContent(projectDetails.get(3), ">(.*)<");
                String projectName = getContent(projectDetails.get(5), ">(.*)<");
                String contactPerson = getContent(projectDetails.get(25 + offsetIndex), ">(.*)<");
                String contactPhone = getContent(projectDetails.get(27 + offsetIndex), ">(.*)<");
                // 公告发布时间
                Date tenderAnnounceTime = DateTimeUtil.stringToDate(getContent(page.getHtml().xpath("//div[@class='articleTitle_details']"), ">(.*)<"), "yyyy-MM-dd");
                // 标书购买截止时间
                Date bidPurchaseDeadline = DateTimeUtil.stringToDate(getContent(projectDetails.get(15 + offsetIndex), ">(.*)<"), DateTimeUtil.DEFAULT_FORMAT);

                projectDetail.setProjectId(projectId);
                projectDetail.setProjectName(projectName);
                projectDetail.setProjectDescription("详见招标公告文件");
                projectDetail.setTenderAnnounceTime(tenderAnnounceTime);
                projectDetail.setTenderDeadline(bidPurchaseDeadline);
                projectDetail.setContactPerson(contactPerson);
                projectDetail.setContactPhone(contactPhone);
                projectDetail.setRemark(StringUtils.EMPTY);
                projectDetail.setSourceWebsite(WebsiteEnum.SGCC.getName());
                projectDetail.setSourceUrl(page.getUrl().toString());

                if (projectDetails.get(0) == null) {
                    page.setSkip(true);
                } else {
                    page.putField(FIELD_KEY, projectDetail);
                }
            }
        } catch (Exception e) {
            LOGGER.error("数据抓取异常" + e.getMessage(), e);
        }
    }

    /**
     * Method getSite returns the site of this BasePageProcessor object.
     *
     *  Field site 目标网站
     *
     * @return the site (type Site) of this BasePageProcessor object.
     */
    @Override
    public Site getSite() {
        return site;
    }
}
