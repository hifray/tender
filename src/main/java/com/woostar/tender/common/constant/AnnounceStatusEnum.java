package com.woostar.tender.common.constant;

/**
 * Enum AnnounceStatusEnum 公告状态枚举类
 *
 * @author huangshuo
 * Created on 2018-08-06
 */
public enum AnnounceStatusEnum {

    /**
     * Field PROCESSING 报名中
     */
    PROCESSING("报名中", 1),
    /**
     * Field CLOSED 已截止
     */
    CLOSED("已截止", 2),
    /**
     * Field ALL 全部
     */
    ALL("全部", 3);

    /**
     * Field status 报名状态
     */
    private String status;
    /**
     * Field code 状态编号
     */
    private Integer code;

    /**
     * Constructor AnnounceStatusEnum creates a new AnnounceStatusEnum instance.
     *
     * @param status of type String
     * @param code of type Integer
     */
    AnnounceStatusEnum(String status, Integer code) {
        this.status = status;
        this.code = code;
    }

    /**
     * Method getStatus returns the status of this AnnounceStatusEnum object.
     *
     *  Field status 报名状态
     *
     * @return the status (type String) of this AnnounceStatusEnum object.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Method getCode returns the code of this AnnounceStatusEnum object.
     *
     *  Field code 状态编号
     *
     * @return the code (type Integer) of this AnnounceStatusEnum object.
     */
    public Integer getCode() {
        return code;
    }
}
