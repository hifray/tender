package com.woostar.tender.webmagic.processor;

import com.woostar.tender.common.util.DateTimeUtil;
import com.woostar.tender.model.SGCCProjectDetail;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.selector.Selectable;

import java.util.Date;
import java.util.List;

/**
 * @author huangs
 * @createtime 2018-06-26
 * @description
 */
public class SGCCPageProcessor extends BaseProcessor {

    public static final String LIST_URL = "http://ecp.sgcc.com.cn/topic_project_list.jsp?";

    public static final String LIST_URL_PARAMETERS = "company_id=00&status=2";

    public static final String FIELD_KEY = "sgccProjectDetail";

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
                SGCCProjectDetail sgccProjectDetail = new SGCCProjectDetail();
                List<Selectable> ssgcProjectDetails = page.getHtml().xpath("//tbody/tr/td").nodes();
                // 页面有无报名截止日期
                int offsetIndex = ssgcProjectDetails.size() == 34 ? 2 : 0;
                // 获取项目信息
                String projectId = getContent(ssgcProjectDetails.get(3), ">(.*)<");
                String projectName = getContent(ssgcProjectDetails.get(5), ">(.*)<");
                // 截标时间
                Date closingTime = DateTimeUtil.stringToDate(getContent(ssgcProjectDetails.get(7 + offsetIndex), ">(.*)<"), DateTimeUtil.DEFAULT_FORMAT);
                // 开标时间
                Date openingTime = DateTimeUtil.stringToDate(getContent(ssgcProjectDetails.get(9 + offsetIndex), ">(.*)<"), DateTimeUtil.DEFAULT_FORMAT);
                String projectType = getContent(ssgcProjectDetails.get(11 + offsetIndex), ">(.*)<");
                String bidPaymentType = getContent(ssgcProjectDetails.get(13 + offsetIndex), ">(.*)<");
                // 标书购买截止日期
                Date bidPurchaseDeadline = DateTimeUtil.stringToDate(getContent(ssgcProjectDetails.get(15 + offsetIndex), ">(.*)<"), DateTimeUtil.DEFAULT_FORMAT);
                String tenderAgency = getContent(ssgcProjectDetails.get(21 + offsetIndex), ">(.*)<");
                String proxyAgency = getContent(ssgcProjectDetails.get(23 + offsetIndex), ">(.*)<");
                String contactPerson = getContent(ssgcProjectDetails.get(25 + offsetIndex), ">(.*)<");
                String contactPhone = getContent(ssgcProjectDetails.get(27 + offsetIndex), ">(.*)<");
                String fox = getContent(ssgcProjectDetails.get(29 + offsetIndex), ">(.*)<");
                String email = getContent(ssgcProjectDetails.get(31 + offsetIndex), ">(.*)<");

                sgccProjectDetail.setProjectId(projectId);
                sgccProjectDetail.setProjectName(projectName);
                sgccProjectDetail.setClosingTime(closingTime);
                sgccProjectDetail.setOpeningTime(openingTime);
                sgccProjectDetail.setProjectType(projectType);
                sgccProjectDetail.setBidPaymentMode(bidPaymentType);
                sgccProjectDetail.setBidPurchaseDeadline(bidPurchaseDeadline);
                sgccProjectDetail.setTenderAgency(tenderAgency);
                sgccProjectDetail.setProxyAgency(proxyAgency);
                sgccProjectDetail.setContactPerson(contactPerson);
                sgccProjectDetail.setContactPhone(contactPhone);
                sgccProjectDetail.setFox(fox);
                sgccProjectDetail.seteMail(email);

                if (ssgcProjectDetails.get(0) == null) {
                    page.setSkip(true);
                } else {
                    page.putField(FIELD_KEY, sgccProjectDetail);
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

    public static void main(String[] args) {
        Spider.create(new SGCCPageProcessor())
                .addUrl(LIST_URL + LIST_URL_PARAMETERS)
                .thread(5)
                .run();
    }
}
