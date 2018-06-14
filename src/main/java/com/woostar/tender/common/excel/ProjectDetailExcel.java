package com.woostar.tender.common.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * @author huangs
 * @createtime 2018-06-11
 * @description
 */
public class ProjectDetailExcel implements java.io.Serializable {

    @Excel(name = "招标项目名称", height = 30, width = 40)
    private String tenderProjectName;

    @Excel(name = " 报建名称", width = 40)
    private String reportName;

    @Excel(name = "招标登记编号", width = 30)
    private String tenderRegistrationNumber;

    @Excel(name = "报建编号", width = 30)
    private String reportNumber;

    @Excel(name = "招标内容说明", width = 50)
    private String tenderProjectDescription;

    @Excel(name = "招标人联系人", width = 20)
    private String tenderContactPerson;

    @Excel(name = "招标人联系电话", width = 25)
    private String tenderContactPhone;

    @Excel(name = "招标人代理联系人", width = 20)
    private String tenderProxyContactPerson;

    @Excel(name = "招标人代理联系人电话", width = 25)
    private String tenderProxyContactPhone;

    @Excel(name = "公告发布日期", width = 20, databaseFormat = "yyyyMMddHHmmss", format = "yyyy年MM月dd日")
    private Date announcementReleaseTime;

    @Excel(name = "报名截止日期", width = 20, databaseFormat = "yyyyMMddHHmmss", format = "yyyy年MM月dd日")
    private Date tenderDeadline;

    @Excel(name = "备注", width = 50)
    private String remark;

    public String getTenderProjectName() {
        return tenderProjectName;
    }

    public void setTenderProjectName(String tenderProjectName) {
        this.tenderProjectName = tenderProjectName;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getTenderRegistrationNumber() {
        return tenderRegistrationNumber;
    }

    public void setTenderRegistrationNumber(String tenderRegistrationNumber) {
        this.tenderRegistrationNumber = tenderRegistrationNumber;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getTenderProjectDescription() {
        return tenderProjectDescription;
    }

    public void setTenderProjectDescription(String tenderProjectDescription) {
        this.tenderProjectDescription = tenderProjectDescription;
    }

    public String getTenderContactPerson() {
        return tenderContactPerson;
    }

    public void setTenderContactPerson(String tenderContactPerson) {
        this.tenderContactPerson = tenderContactPerson;
    }

    public String getTenderContactPhone() {
        return tenderContactPhone;
    }

    public void setTenderContactPhone(String tenderContactPhone) {
        this.tenderContactPhone = tenderContactPhone;
    }

    public String getTenderProxyContactPerson() {
        return tenderProxyContactPerson;
    }

    public void setTenderProxyContactPerson(String tenderProxyContactPerson) {
        this.tenderProxyContactPerson = tenderProxyContactPerson;
    }

    public String getTenderProxyContactPhone() {
        return tenderProxyContactPhone;
    }

    public void setTenderProxyContactPhone(String tenderProxyContactPhone) {
        this.tenderProxyContactPhone = tenderProxyContactPhone;
    }

    public Date getTenderDeadline() {
        return tenderDeadline;
    }

    public void setTenderDeadline(Date tenderDeadline) {
        this.tenderDeadline = tenderDeadline;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getAnnouncementReleaseTime() {
        return announcementReleaseTime;
    }

    public void setAnnouncementReleaseTime(Date announcementReleaseTime) {
        this.announcementReleaseTime = announcementReleaseTime;
    }

    @Override
    public String toString() {
        return "ProjectDetailExcel{" +
                "tenderProjectName='" + tenderProjectName + '\'' +
                ", reportName='" + reportName + '\'' +
                ", tenderRegistrationNumber='" + tenderRegistrationNumber + '\'' +
                ", reportNumber='" + reportNumber + '\'' +
                ", tenderProjectDescription='" + tenderProjectDescription + '\'' +
                ", tenderContactPerson='" + tenderContactPerson + '\'' +
                ", tenderContactPhone='" + tenderContactPhone + '\'' +
                ", tenderProxyContactPerson='" + tenderProxyContactPerson + '\'' +
                ", tenderProxyContactPhone='" + tenderProxyContactPhone + '\'' +
                ", announcementReleaseTime=" + announcementReleaseTime +
                ", tenderDeadline=" + tenderDeadline +
                ", remark='" + remark + '\'' +
                '}';
    }
}
