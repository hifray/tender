package com.woostar.tender.webmagic.processor;

import com.woostar.tender.common.constant.Website;
import com.woostar.tender.common.util.DateTimeUtil;
import com.woostar.tender.model.ProjectDetail;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.selector.Selectable;

import java.util.Date;
import java.util.List;

/**
 * @author huangs
 * @createtime 2018-06-26
 * @description
 */
public class SGCCPageProcessor extends BasePageProcessor {

    public static final String LIST_URL = "http://ecp.sgcc.com.cn/topic_project_list.jsp?";

    public static final String LIST_URL_PARAMETERS = "company_id=00&status=2";

    /**
     * 爬虫主逻辑方法
     * @param page 爬取的页面
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
                Date tenderAnnounceTime = DateTimeUtil.stringToDate(getContent(page.getHtml().xpath("//div[@class='articleTitle_details']"), ">(.*)<"), "yyyy-MM-DD");
                // 标书购买截止日期
                Date bidPurchaseDeadline = DateTimeUtil.stringToDate(getContent(projectDetails.get(15 + offsetIndex), ">(.*)<"), DateTimeUtil.DEFAULT_FORMAT);
//                // 截标时间
//                Date closingTime = DateTimeUtil.stringToDate(getContent(projectDetails.get(7 + offsetIndex), ">(.*)<"), DateTimeUtil.DEFAULT_FORMAT);
//                // 开标时间
//                Date openingTime = DateTimeUtil.stringToDate(getContent(projectDetails.get(9 + offsetIndex), ">(.*)<"), DateTimeUtil.DEFAULT_FORMAT);
//                String projectType = getContent(projectDetails.get(11 + offsetIndex), ">(.*)<");
//                String bidPaymentType = getContent(projectDetails.get(13 + offsetIndex), ">(.*)<");
//                String tenderAgency = getContent(projectDetails.get(21 + offsetIndex), ">(.*)<");
//                String proxyAgency = getContent(projectDetails.get(23 + offsetIndex), ">(.*)<");
//                String fox = getContent(projectDetails.get(29 + offsetIndex), ">(.*)<");
//                String email = getContent(projectDetails.get(31 + offsetIndex), ">(.*)<");

                projectDetail.setProjectId(projectId);
                projectDetail.setProjectName(projectName);
                projectDetail.setProjectDescription(StringUtils.EMPTY);
                projectDetail.setTenderAnnounceTime(tenderAnnounceTime);
                projectDetail.setTenderDeadline(bidPurchaseDeadline);
                projectDetail.setContactPerson(contactPerson);
                projectDetail.setContactPhone(contactPhone);
                projectDetail.setSourceWebsite(Website.SGCC.getName());
                projectDetail.setSourceUrl(page.getUrl().toString());
//                projectDetail.setClosingTime(closingTime);
//                projectDetail.setOpeningTime(openingTime);
//                projectDetail.setProjectType(projectType);
//                projectDetail.setBidPaymentMode(bidPaymentType);
//                projectDetail.setTenderAgency(tenderAgency);
//                projectDetail.setProxyAgency(proxyAgency);
//                projectDetail.setFox(fox);
//                projectDetail.seteMail(email);

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

    @Override
    public Site getSite() {
        return site;
    }
}
