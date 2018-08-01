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

    /**
     * Field serialVersionUID
     */
    private static final long serialVersionUID = 4880061842792317921L;

	/**
     * Field tenderProjectName 招标项目名称
     */
    @Excel(name = "招标项目名称", height = 30, width = 40)
    private String tenderProjectName;

    /**
     * Field 报建名称
     */
    @Excel(name = " 报建名称", width = 40)
    private String reportName;

    /**
     * Field tenderRegistrationNumber 招标登记编号
     */
    @Excel(name = "招标登记编号", width = 30)
    private String tenderRegistrationNumber;

    /**
     * Field reportNumber 报建编号
     */
    @Excel(name = "报建编号", width = 30)
    private String reportNumber;

    /**
     * Field tenderProjectDescription 招标内容说明
     */
    @Excel(name = "招标内容说明", width = 50)
    private String tenderProjectDescription;

    /**
     * Field tenderContactPerson 招标人联系人
     */
    @Excel(name = "招标人联系人", width = 20)
    private String tenderContactPerson;

    /**
     * Field tenderContactPhone 招标人联系电话
     */
    @Excel(name = "招标人联系电话", width = 25)
    private String tenderContactPhone;

    /**
     * Field tenderProxyContactPerson 招标人代理联系人
     */
    @Excel(name = "招标人代理联系人", width = 20)
    private String tenderProxyContactPerson;

    /**
     * Field tenderProxyContactPhone 招标人代理联系人电话
     */
    @Excel(name = "招标人代理联系人电话", width = 25)
    private String tenderProxyContactPhone;

    /**
     * Field announcementReleaseTime 公告发布日期
     */
    @Excel(name = "公告发布日期", width = 20, databaseFormat = "yyyyMMddHHmmss", format = "yyyy年MM月dd日")
    private Date announcementReleaseTime;

    /**
     * Field tenderDeadline 报名截止日期
     */
    @Excel(name = "报名截止日期", width = 20, databaseFormat = "yyyyMMddHHmmss", format = "yyyy年MM月dd日")
    private Date tenderDeadline;

    /**
     * Field remark 备注
     */
    @Excel(name = "备注", width = 50)
    private String remark;

    /**
     * Method getTenderProjectName returns the tenderProjectName of this ProjectDetailExcel object.
     *
     *  Field tenderProjectName 招标项目名称
     *
     * @return the tenderProjectName (type String) of this ProjectDetailExcel object.
     */
    public String getTenderProjectName() {
        return tenderProjectName;
    }

    /**
     * Method setTenderProjectName sets the tenderProjectName of this ProjectDetailExcel object.
     *
     *  Field tenderProjectName 招标项目名称
     *
     * @param tenderProjectName the tenderProjectName of this ProjectDetailExcel object.
     *
     */
    public void setTenderProjectName(String tenderProjectName) {
        this.tenderProjectName = tenderProjectName;
    }

    /**
     * Method getReportName returns the reportName of this ProjectDetailExcel object.
     *
     *  Field 报建名称
     *
     * @return the reportName (type String) of this ProjectDetailExcel object.
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * Method setReportName sets the reportName of this ProjectDetailExcel object.
     *
     *  Field 报建名称
     *
     * @param reportName the reportName of this ProjectDetailExcel object.
     *
     */
    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    /**
     * Method getTenderRegistrationNumber returns the tenderRegistrationNumber of this ProjectDetailExcel object.
     *
     *  Field tenderRegistrationNumber 招标登记编号
     *
     * @return the tenderRegistrationNumber (type String) of this ProjectDetailExcel object.
     */
    public String getTenderRegistrationNumber() {
        return tenderRegistrationNumber;
    }

    /**
     * Method setTenderRegistrationNumber sets the tenderRegistrationNumber of this ProjectDetailExcel object.
     *
     *  Field tenderRegistrationNumber 招标登记编号
     *
     * @param tenderRegistrationNumber the tenderRegistrationNumber of this ProjectDetailExcel object.
     *
     */
    public void setTenderRegistrationNumber(String tenderRegistrationNumber) {
        this.tenderRegistrationNumber = tenderRegistrationNumber;
    }

    /**
     * Method getReportNumber returns the reportNumber of this ProjectDetailExcel object.
     *
     *  Field reportNumber 报建编号
     *
     * @return the reportNumber (type String) of this ProjectDetailExcel object.
     */
    public String getReportNumber() {
        return reportNumber;
    }

    /**
     * Method setReportNumber sets the reportNumber of this ProjectDetailExcel object.
     *
     *  Field reportNumber 报建编号
     *
     * @param reportNumber the reportNumber of this ProjectDetailExcel object.
     *
     */
    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    /**
     * Method getTenderProjectDescription returns the tenderProjectDescription of this ProjectDetailExcel object.
     *
     *  Field tenderProjectDescription 招标内容说明
     *
     * @return the tenderProjectDescription (type String) of this ProjectDetailExcel object.
     */
    public String getTenderProjectDescription() {
        return tenderProjectDescription;
    }

    /**
     * Method setTenderProjectDescription sets the tenderProjectDescription of this ProjectDetailExcel object.
     *
     *  Field tenderProjectDescription 招标内容说明
     *
     * @param tenderProjectDescription the tenderProjectDescription of this ProjectDetailExcel object.
     *
     */
    public void setTenderProjectDescription(String tenderProjectDescription) {
        this.tenderProjectDescription = tenderProjectDescription;
    }

    /**
     * Method getTenderContactPerson returns the tenderContactPerson of this ProjectDetailExcel object.
     *
     *  Field tenderContactPerson 招标人联系人
     *
     * @return the tenderContactPerson (type String) of this ProjectDetailExcel object.
     */
    public String getTenderContactPerson() {
        return tenderContactPerson;
    }

    /**
     * Method setTenderContactPerson sets the tenderContactPerson of this ProjectDetailExcel object.
     *
     *  Field tenderContactPerson 招标人联系人
     *
     * @param tenderContactPerson the tenderContactPerson of this ProjectDetailExcel object.
     *
     */
    public void setTenderContactPerson(String tenderContactPerson) {
        this.tenderContactPerson = tenderContactPerson;
    }

    /**
     * Method getTenderContactPhone returns the tenderContactPhone of this ProjectDetailExcel object.
     *
     *  Field tenderContactPhone 招标人联系电话
     *
     * @return the tenderContactPhone (type String) of this ProjectDetailExcel object.
     */
    public String getTenderContactPhone() {
        return tenderContactPhone;
    }

    /**
     * Method setTenderContactPhone sets the tenderContactPhone of this ProjectDetailExcel object.
     *
     *  Field tenderContactPhone 招标人联系电话
     *
     * @param tenderContactPhone the tenderContactPhone of this ProjectDetailExcel object.
     *
     */
    public void setTenderContactPhone(String tenderContactPhone) {
        this.tenderContactPhone = tenderContactPhone;
    }

    /**
     * Method getTenderProxyContactPerson returns the tenderProxyContactPerson of this ProjectDetailExcel object.
     *
     *  Field tenderProxyContactPerson 招标人代理联系人
     *
     * @return the tenderProxyContactPerson (type String) of this ProjectDetailExcel object.
     */
    public String getTenderProxyContactPerson() {
        return tenderProxyContactPerson;
    }

    /**
     * Method setTenderProxyContactPerson sets the tenderProxyContactPerson of this ProjectDetailExcel object.
     *
     *  Field tenderProxyContactPerson 招标人代理联系人
     *
     * @param tenderProxyContactPerson the tenderProxyContactPerson of this ProjectDetailExcel object.
     *
     */
    public void setTenderProxyContactPerson(String tenderProxyContactPerson) {
        this.tenderProxyContactPerson = tenderProxyContactPerson;
    }

    /**
     * Method getTenderProxyContactPhone returns the tenderProxyContactPhone of this ProjectDetailExcel object.
     *
     *  Field tenderProxyContactPhone 招标人代理联系人电话
     *
     * @return the tenderProxyContactPhone (type String) of this ProjectDetailExcel object.
     */
    public String getTenderProxyContactPhone() {
        return tenderProxyContactPhone;
    }

    /**
     * Method setTenderProxyContactPhone sets the tenderProxyContactPhone of this ProjectDetailExcel object.
     *
     *  Field tenderProxyContactPhone 招标人代理联系人电话
     *
     * @param tenderProxyContactPhone the tenderProxyContactPhone of this ProjectDetailExcel object.
     *
     */
    public void setTenderProxyContactPhone(String tenderProxyContactPhone) {
        this.tenderProxyContactPhone = tenderProxyContactPhone;
    }

    /**
     * Method getTenderDeadline returns the tenderDeadline of this ProjectDetailExcel object.
     *
     *  Field tenderDeadline 报名截止日期
     *
     * @return the tenderDeadline (type Date) of this ProjectDetailExcel object.
     */
    public Date getTenderDeadline() {
        return tenderDeadline;
    }

    /**
     * Method setTenderDeadline sets the tenderDeadline of this ProjectDetailExcel object.
     *
     *  Field tenderDeadline 报名截止日期
     *
     * @param tenderDeadline the tenderDeadline of this ProjectDetailExcel object.
     *
     */
    public void setTenderDeadline(Date tenderDeadline) {
        this.tenderDeadline = tenderDeadline;
    }

    /**
     * Method getRemark returns the remark of this ProjectDetailExcel object.
     *
     *  Field remark 备注
     *
     * @return the remark (type String) of this ProjectDetailExcel object.
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Method setRemark sets the remark of this ProjectDetailExcel object.
     *
     *  Field remark 备注
     *
     * @param remark the remark of this ProjectDetailExcel object.
     *
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Method getAnnouncementReleaseTime returns the announcementReleaseTime of this ProjectDetailExcel object.
     *
     *  Field announcementReleaseTime 公告发布日期
     *
     * @return the announcementReleaseTime (type Date) of this ProjectDetailExcel object.
     */
    public Date getAnnouncementReleaseTime() {
        return announcementReleaseTime;
    }

    /**
     * Method setAnnouncementReleaseTime sets the announcementReleaseTime of this ProjectDetailExcel object.
     *
     *  Field announcementReleaseTime 公告发布日期
     *
     * @param announcementReleaseTime the announcementReleaseTime of this ProjectDetailExcel object.
     *
     */
    public void setAnnouncementReleaseTime(Date announcementReleaseTime) {
        this.announcementReleaseTime = announcementReleaseTime;
    }

    /**
     * Method toString
     * @return String
     */
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
