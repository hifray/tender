package com.woostar.tender.common.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * Class ProjectDetailExcel 项目信息导出Excel模板类
 *
 * @author huangshuo
 * Created on 2018-06-11
 */
public class ProjectDetailExcel implements java.io.Serializable {

    private static final long serialVersionUID = 4880061842792317921L;

    @Excel(name = "项目名称", height = 30, width = 40)
    private String projectName;

    @Excel(name = "项目编号", width = 30)
    private String projectId;

    @Excel(name = "招标内容说明", width = 50)
    private String projectDescription;

    @Excel(name = "联系人", width = 20)
    private String contactPerson;

    @Excel(name = "联系电话", width = 25)
    private String contactPhone;

    @Excel(name = "公告发布日期", width = 20, databaseFormat = "yyyyMMddHHmmss", format = "yyyy年MM月dd日")
    private Date tenderAnnounceTime;

    @Excel(name = "报名截止日期", width = 20, databaseFormat = "yyyyMMddHHmmss", format = "yyyy年MM月dd日")
    private Date tenderDeadline;

    @Excel(name = "来源网站", width = 25)
    private String sourceWebsite;

    @Excel(name = "备注", width = 50)
    private String remark;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Date getTenderAnnounceTime() {
        return tenderAnnounceTime;
    }

    public void setTenderAnnounceTime(Date tenderAnnounceTime) {
        this.tenderAnnounceTime = tenderAnnounceTime;
    }

    public Date getTenderDeadline() {
        return tenderDeadline;
    }

    public void setTenderDeadline(Date tenderDeadline) {
        this.tenderDeadline = tenderDeadline;
    }

    public String getSourceWebsite() {
        return sourceWebsite;
    }

    public void setSourceWebsite(String sourceWebsite) {
        this.sourceWebsite = sourceWebsite;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ProjectDetailExcel{" +
                "projectName='" + projectName + '\'' +
                ", projectId='" + projectId + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", tenderAnnounceTime=" + tenderAnnounceTime +
                ", tenderDeadline=" + tenderDeadline +
                ", sourceWebsite='" + sourceWebsite + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
