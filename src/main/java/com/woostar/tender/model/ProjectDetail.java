package com.woostar.tender.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table tender_project_detail
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class ProjectDetail {
    /**
     * Database Column Remarks:
     *   项目id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tender_project_detail.project_id
     *
     * @mbg.generated
     */
    private String projectId;

    /**
     * Database Column Remarks:
     *   报建编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tender_project_detail.report_number
     *
     * @mbg.generated
     */
    private String reportNumber;

    /**
     * Database Column Remarks:
     *   报建名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tender_project_detail.report_name
     *
     * @mbg.generated
     */
    private String reportName;

    /**
     * Database Column Remarks:
     *   招标登记编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tender_project_detail.tender_registration_number
     *
     * @mbg.generated
     */
    private String tenderRegistrationNumber;

    /**
     * Database Column Remarks:
     *   招标项目名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tender_project_detail.tender_project_name
     *
     * @mbg.generated
     */
    private String tenderProjectName;

    /**
     * Database Column Remarks:
     *   招标人联系人
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tender_project_detail.tender_contact_person
     *
     * @mbg.generated
     */
    private String tenderContactPerson;

    /**
     * Database Column Remarks:
     *   招标人联系人电话
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tender_project_detail.tender_contact_person_phone
     *
     * @mbg.generated
     */
    private String tenderContactPersonPhone;

    /**
     * Database Column Remarks:
     *   招标人代理联系人
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tender_project_detail.tender_proxy_contact_person
     *
     * @mbg.generated
     */
    private String tenderProxyContactPerson;

    /**
     * Database Column Remarks:
     *   招标人代理联系人电话
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tender_project_detail.tender_proxy_contact_person_phone
     *
     * @mbg.generated
     */
    private String tenderProxyContactPersonPhone;

    /**
     * Database Column Remarks:
     *   招标内容说明
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tender_project_detail.tender_project_description
     *
     * @mbg.generated
     */
    private String tenderProjectDescription;

    /**
     * Database Column Remarks:
     *   公告发布时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tender_project_detail.announcement_release_time
     *
     * @mbg.generated
     */
    private Date announcementReleaseTime;

    /**
     * Database Column Remarks:
     *   报名截止时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tender_project_detail.tender_deadline
     *
     * @mbg.generated
     */
    private Date tenderDeadline;

    /**
     * Database Column Remarks:
     *   记录创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tender_project_detail.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   记录更新时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tender_project_detail.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   备注
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tender_project_detail.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tender_project_detail.project_id
     *
     * @return the value of tender_project_detail.project_id
     *
     * @mbg.generated
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tender_project_detail.project_id
     *
     * @param projectId the value for tender_project_detail.project_id
     *
     * @mbg.generated
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tender_project_detail.report_number
     *
     * @return the value of tender_project_detail.report_number
     *
     * @mbg.generated
     */
    public String getReportNumber() {
        return reportNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tender_project_detail.report_number
     *
     * @param reportNumber the value for tender_project_detail.report_number
     *
     * @mbg.generated
     */
    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber == null ? null : reportNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tender_project_detail.report_name
     *
     * @return the value of tender_project_detail.report_name
     *
     * @mbg.generated
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tender_project_detail.report_name
     *
     * @param reportName the value for tender_project_detail.report_name
     *
     * @mbg.generated
     */
    public void setReportName(String reportName) {
        this.reportName = reportName == null ? null : reportName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tender_project_detail.tender_registration_number
     *
     * @return the value of tender_project_detail.tender_registration_number
     *
     * @mbg.generated
     */
    public String getTenderRegistrationNumber() {
        return tenderRegistrationNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tender_project_detail.tender_registration_number
     *
     * @param tenderRegistrationNumber the value for tender_project_detail.tender_registration_number
     *
     * @mbg.generated
     */
    public void setTenderRegistrationNumber(String tenderRegistrationNumber) {
        this.tenderRegistrationNumber = tenderRegistrationNumber == null ? null : tenderRegistrationNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tender_project_detail.tender_project_name
     *
     * @return the value of tender_project_detail.tender_project_name
     *
     * @mbg.generated
     */
    public String getTenderProjectName() {
        return tenderProjectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tender_project_detail.tender_project_name
     *
     * @param tenderProjectName the value for tender_project_detail.tender_project_name
     *
     * @mbg.generated
     */
    public void setTenderProjectName(String tenderProjectName) {
        this.tenderProjectName = tenderProjectName == null ? null : tenderProjectName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tender_project_detail.tender_contact_person
     *
     * @return the value of tender_project_detail.tender_contact_person
     *
     * @mbg.generated
     */
    public String getTenderContactPerson() {
        return tenderContactPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tender_project_detail.tender_contact_person
     *
     * @param tenderContactPerson the value for tender_project_detail.tender_contact_person
     *
     * @mbg.generated
     */
    public void setTenderContactPerson(String tenderContactPerson) {
        this.tenderContactPerson = tenderContactPerson == null ? null : tenderContactPerson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tender_project_detail.tender_contact_person_phone
     *
     * @return the value of tender_project_detail.tender_contact_person_phone
     *
     * @mbg.generated
     */
    public String getTenderContactPersonPhone() {
        return tenderContactPersonPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tender_project_detail.tender_contact_person_phone
     *
     * @param tenderContactPersonPhone the value for tender_project_detail.tender_contact_person_phone
     *
     * @mbg.generated
     */
    public void setTenderContactPersonPhone(String tenderContactPersonPhone) {
        this.tenderContactPersonPhone = tenderContactPersonPhone == null ? null : tenderContactPersonPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tender_project_detail.tender_proxy_contact_person
     *
     * @return the value of tender_project_detail.tender_proxy_contact_person
     *
     * @mbg.generated
     */
    public String getTenderProxyContactPerson() {
        return tenderProxyContactPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tender_project_detail.tender_proxy_contact_person
     *
     * @param tenderProxyContactPerson the value for tender_project_detail.tender_proxy_contact_person
     *
     * @mbg.generated
     */
    public void setTenderProxyContactPerson(String tenderProxyContactPerson) {
        this.tenderProxyContactPerson = tenderProxyContactPerson == null ? null : tenderProxyContactPerson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tender_project_detail.tender_proxy_contact_person_phone
     *
     * @return the value of tender_project_detail.tender_proxy_contact_person_phone
     *
     * @mbg.generated
     */
    public String getTenderProxyContactPersonPhone() {
        return tenderProxyContactPersonPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tender_project_detail.tender_proxy_contact_person_phone
     *
     * @param tenderProxyContactPersonPhone the value for tender_project_detail.tender_proxy_contact_person_phone
     *
     * @mbg.generated
     */
    public void setTenderProxyContactPersonPhone(String tenderProxyContactPersonPhone) {
        this.tenderProxyContactPersonPhone = tenderProxyContactPersonPhone == null ? null : tenderProxyContactPersonPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tender_project_detail.tender_project_description
     *
     * @return the value of tender_project_detail.tender_project_description
     *
     * @mbg.generated
     */
    public String getTenderProjectDescription() {
        return tenderProjectDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tender_project_detail.tender_project_description
     *
     * @param tenderProjectDescription the value for tender_project_detail.tender_project_description
     *
     * @mbg.generated
     */
    public void setTenderProjectDescription(String tenderProjectDescription) {
        this.tenderProjectDescription = tenderProjectDescription == null ? null : tenderProjectDescription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tender_project_detail.announcement_release_time
     *
     * @return the value of tender_project_detail.announcement_release_time
     *
     * @mbg.generated
     */
    public Date getAnnouncementReleaseTime() {
        return announcementReleaseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tender_project_detail.announcement_release_time
     *
     * @param announcementReleaseTime the value for tender_project_detail.announcement_release_time
     *
     * @mbg.generated
     */
    public void setAnnouncementReleaseTime(Date announcementReleaseTime) {
        this.announcementReleaseTime = announcementReleaseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tender_project_detail.tender_deadline
     *
     * @return the value of tender_project_detail.tender_deadline
     *
     * @mbg.generated
     */
    public Date getTenderDeadline() {
        return tenderDeadline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tender_project_detail.tender_deadline
     *
     * @param tenderDeadline the value for tender_project_detail.tender_deadline
     *
     * @mbg.generated
     */
    public void setTenderDeadline(Date tenderDeadline) {
        this.tenderDeadline = tenderDeadline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tender_project_detail.create_time
     *
     * @return the value of tender_project_detail.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tender_project_detail.create_time
     *
     * @param createTime the value for tender_project_detail.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tender_project_detail.update_time
     *
     * @return the value of tender_project_detail.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tender_project_detail.update_time
     *
     * @param updateTime the value for tender_project_detail.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tender_project_detail.remark
     *
     * @return the value of tender_project_detail.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tender_project_detail.remark
     *
     * @param remark the value for tender_project_detail.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table tender_project_detail
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        projectId("project_id", "projectId", "VARCHAR", false),
        reportNumber("report_number", "reportNumber", "VARCHAR", false),
        reportName("report_name", "reportName", "VARCHAR", false),
        tenderRegistrationNumber("tender_registration_number", "tenderRegistrationNumber", "VARCHAR", false),
        tenderProjectName("tender_project_name", "tenderProjectName", "VARCHAR", false),
        tenderContactPerson("tender_contact_person", "tenderContactPerson", "VARCHAR", false),
        tenderContactPersonPhone("tender_contact_person_phone", "tenderContactPersonPhone", "VARCHAR", false),
        tenderProxyContactPerson("tender_proxy_contact_person", "tenderProxyContactPerson", "VARCHAR", false),
        tenderProxyContactPersonPhone("tender_proxy_contact_person_phone", "tenderProxyContactPersonPhone", "VARCHAR", false),
        tenderProjectDescription("tender_project_description", "tenderProjectDescription", "VARCHAR", false),
        announcementReleaseTime("announcement_release_time", "announcementReleaseTime", "TIMESTAMP", false),
        tenderDeadline("tender_deadline", "tenderDeadline", "TIMESTAMP", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        remark("remark", "remark", "VARCHAR", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tender_project_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tender_project_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tender_project_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tender_project_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tender_project_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tender_project_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tender_project_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tender_project_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tender_project_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tender_project_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tender_project_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tender_project_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tender_project_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tender_project_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tender_project_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }
    }
}