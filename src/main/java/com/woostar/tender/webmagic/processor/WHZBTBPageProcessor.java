package com.woostar.tender.webmagic.processor;

import com.woostar.tender.common.constant.WebsiteEnum;
import com.woostar.tender.common.util.DateTimeUtil;
import com.woostar.tender.model.ProjectDetail;
import org.apache.commons.collections.CollectionUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.selector.Selectable;

import java.util.Date;
import java.util.List;

/**
 * Class WHZBTBPageProcessor 武汉市公共资源中心PageProcessor类
 *
 * @author huangshuo
 * Created on 2018-06-01
 */
public class WHZBTBPageProcessor extends BasePageProcessor {

    /**
     * Field DETAIL_URL_PARAMETER 项目信息参数(第一页、每页150个、公告状态为报名中)
     */
    public static final String DETAIL_URL_PARAMETER = "page=1&rows=150&bmFlag=0";

    /**
     * Field DETAIL_URL 爬虫初始请求地址
     */
    private static final String DETAIL_URL = "http://www.jy.whzbtb.com/V2PRTS/TendererNoticeInfoDetail.do?id=";

    /**
     * Field LIST_URL 项目信息列表请求地址
     */
    public static final String LIST_URL = "http://www.jy.whzbtb.com/V2PRTS/TendererNoticeInfoList.do?";

    /**
     * Method process 爬虫主方法
     *
     * @param page of type Page
     */
    @Override
    public void process(Page page) {
        try {
            if (page.getUrl().regex(LIST_URL + "\\w+").match()) {
                // 获取项目Id列表
                List<String> projectIdList = page.getJson().jsonPath("$.rows[*].id").all();
                if (CollectionUtils.isNotEmpty(projectIdList)) {
                    for (String projectId : projectIdList) {
                        // 添加至爬虫请求队列
                        page.addTargetRequest(DETAIL_URL + projectId);
                    }
                }
            } else {
                // 获取招标项目信息详情
                ProjectDetail projectDetail = new ProjectDetail();
                List<Selectable> projectDetails = page.getHtml().xpath("//table[@class='header-table']/tbody/tr/td[@class='grid-font-tb']").nodes();
                // 获取项目信息
                String reportNumber = getContent(projectDetails.get(0), ">(.*)<");
                String reportName = getContent(projectDetails.get(1), ">(.*)<");
                String tenderProjectDescription = getContent(projectDetails.get(19), ">(.*)<");
                String tenderContactPerson = getContent(projectDetails.get(8), ">(.*)<");
                String tenderContactPersonPhone = getContent(projectDetails.get(9), ">(.*)<");
                // 招标截止日期
                Date tenderDeadline = DateTimeUtil.stringToDate(getContent(projectDetails.get(27), "~(.*)</span>").trim(), "yyyy-MM-dd HH:mm");
                // 公告发布日期
                Date announcementReleaseTime = DateTimeUtil.stringToDate(getContent(projectDetails.get(27), "<span>(.*)~").trim(), "yyyy-MM-dd HH:mm");
                String remark = getContent(projectDetails.get(43), "<span>(.*)</span>");

                projectDetail.setProjectId(reportNumber);
                projectDetail.setProjectName(reportName);
                projectDetail.setProjectDescription(tenderProjectDescription);
                projectDetail.setTenderDeadline(tenderDeadline);
                projectDetail.setTenderAnnounceTime(announcementReleaseTime);
                projectDetail.setContactPerson(tenderContactPerson);
                projectDetail.setContactPhone(tenderContactPersonPhone);
                projectDetail.setSourceWebsite(WebsiteEnum.WHZBTB.getName());
                projectDetail.setSourceUrl(page.getUrl().toString());
                projectDetail.setRemark(remark);

                if (projectDetails.get(0) == null) {
                    page.setSkip(true);
                } else {
                    page.putField(FIELD_KEY, projectDetail);
                }
            }
        } catch (Exception e) {
            LOGGER.error("信息抓取异常" + e.getMessage(), e);
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
