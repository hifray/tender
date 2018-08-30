package com.woostar.tender.webmagic.processor;

import com.woostar.tender.common.constant.WebsiteEnum;
import com.woostar.tender.common.util.DateTimeUtil;
import com.woostar.tender.model.ProjectDetail;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.selector.Selectable;

import java.util.Date;
import java.util.List;

/**
 * Class BIDCHANCEPageProcessor 招标网PageProcessor类
 *
 * @author huangshuo
 * Created on 2018-07-15
 */
public class BIDCHANCEPageProcessor extends BasePageProcessor {

    /**
     * Field LIST_URL 爬虫初始请求地址
     */
    public static final String LIST_URL = "http://www.bidchance.com/outlinegonggao.html";

    /**
     * Field TARGET_URL 项目信息请求地址
     */
    private static final String TARGET_URL = "http://www.bidchance.com/info-gonggao-";

    /**
     * Field site 目标网站
     */
    private Site site = Site.me()
            // 防止中文信息出现乱码
            .setCharset("GBK")
            .setSleepTime(3000)
            .setRetryTimes(5)
            .setTimeOut(10000)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36");

    /**
     * Method process 爬虫主方法
     *
     * @param page of type Page
     */
    @Override
    public void process(Page page) {
        try {
            if (page.getUrl().regex(LIST_URL).match()) {
                // 获取项目详情链接
                List<Selectable> selectableList = page.getHtml().xpath("//li[@class='glli']/a[@class='big']/@href").nodes();
                for (Selectable selectable : selectableList) {
                    // 添加项目详情链接至请求队列
                    page.addTargetRequest(selectable.toString());
                }
            } else if (page.getUrl().regex(TARGET_URL + "\\w+").match()){
                ProjectDetail projectDetail = new ProjectDetail();

                String projectName = getContent(page.getHtml().xpath("//div[@id='infotitle']"), ">(.*)<");
                Date tenderAnnounceTime = DateTimeUtil.stringToDate(page.getHtml().xpath("//div[@class='xllabel-l']/span[@id='infopubdate']").regex(">(.*)<").toString().replace(".", "-"), "yyyy-MM-dd");

                projectDetail.setProjectName(projectName);
                projectDetail.setTenderAnnounceTime(tenderAnnounceTime);
                projectDetail.setSourceUrl(page.getUrl().toString());
                projectDetail.setSourceWebsite(WebsiteEnum.BIDCHANCE.getName());

                page.putField(FIELD_KEY, projectDetail);
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
