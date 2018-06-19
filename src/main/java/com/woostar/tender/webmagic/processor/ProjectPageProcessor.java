package com.woostar.tender.webmagic.processor;

import com.woostar.tender.common.util.DateTimeUtil;
import com.woostar.tender.model.ProjectDetail;
import org.apache.commons.collections.CollectionUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.selector.Selectable;

import java.util.Date;
import java.util.List;

/**
 * @author huangs
 * @createtime 2018-06-01
 * @description 招标项目爬取processor
 */
public class ProjectPageProcessor extends BaseProcessor {
    /**
     * 爬取项目信息参数(第一页、每页十个、公告状态为报名中)
     */
    public static final String DETAIL_URL_PARAMETER = "page=1&rows=150";

    /**
     * 目标链接
     */
    private static final String DETAIL_URL = "http://www.jy.whzbtb.com/V2PRTS/TendererNoticeInfoDetail.do?id=";
    /**
     * 获取招标信列表链接
     */
    public static final String LIST_URL = "http://www.jy.whzbtb.com/V2PRTS/TendererNoticeInfoList.do?";

    /**
     * 爬虫主逻辑方法
     * @param page 爬取的页面
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
                String tenderRegistrationNumber = getContent(projectDetails.get(2), ">(.*)<");
                String tenderProjectName = getContent(projectDetails.get(3), ">(.*)<");
                String tenderContactPerson = getContent(projectDetails.get(8), ">(.*)<");
                String tenderContactPersonPhone = getContent(projectDetails.get(9), ">(.*)<");
                String tenderProxyContactPerson = getContent(projectDetails.get(10), ">(.*)<");
                String tenderProxyContactPersonPhone = getContent(projectDetails.get(11), ">(.*)<");
                String tenderProjectDescription = getContent(projectDetails.get(19), ">(.*)<");
                // 招标截止日期
                Date tenderDeadline = DateTimeUtil.stringToDate(getContent(projectDetails.get(27), "~(.*)</span>").trim(), "yyyy-MM-dd HH:mm");
                // 公告发布日期
                Date announcementReleaseTime = DateTimeUtil.stringToDate(getContent(projectDetails.get(27), "<span>(.*)~").trim(), "yyyy-MM-dd HH:mm");
                String remark = getContent(projectDetails.get(43), "<span>(.*)</span>");
                // 根据页面的链接截取项目id
                String projectId = page.getRequest().getUrl().replace(DETAIL_URL, "");

                projectDetail.setProjectId(projectId);
                projectDetail.setReportNumber(reportNumber);
                projectDetail.setReportName(reportName);
                projectDetail.setTenderRegistrationNumber(tenderRegistrationNumber);
                projectDetail.setTenderProjectName(tenderProjectName);
                projectDetail.setTenderContactPerson(tenderContactPerson);
                projectDetail.setTenderContactPersonPhone(tenderContactPersonPhone);
                projectDetail.setTenderProxyContactPerson(tenderProxyContactPerson);
                projectDetail.setTenderProxyContactPersonPhone(tenderProxyContactPersonPhone);
                projectDetail.setTenderProjectDescription(tenderProjectDescription);
                projectDetail.setTenderDeadline(tenderDeadline);
                projectDetail.setAnnouncementReleaseTime(announcementReleaseTime);
                projectDetail.setRemark(remark);

                if (projectDetails.get(0) == null) {
                    page.setSkip(true);
                } else {
                    page.putField("projectDetail", projectDetail);
                }
            }
        } catch (Exception e) {
            LOGGER.error("信息抓取异常" + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        Spider.create(new ProjectPageProcessor())
                .addUrl(LIST_URL + DETAIL_URL_PARAMETER)
                .thread(5)
                .run();
    }

    @Override
    public Site getSite() {
        return site;
    }

    private String getContent(Selectable selectable, String regexString) {
        // 去掉文本内容中的 &nbsp;
        return selectable.replace("&nbsp;", "").regex(regexString).toString();
    }

}
