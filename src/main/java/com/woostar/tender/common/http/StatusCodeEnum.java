package com.woostar.tender.common.http;

/**
 * Enum StatusCodeEnum 服务器响应状态码枚举类
 *
 * @author huangshuo
 * Created on 2018-06-05
 */
public enum StatusCodeEnum {

    /**
     * Field OK
     */
    OK(200, "OK"),
    /**
     * Field Created
     */
    Created(201, "Created"),
    /**
     * Field Accepted
     */
    Accepted(202, "Accepted"),

    /**
     * Field MovedPermanently
     */
    MovedPermanently(301, "Moved Permanently"),
    /**
     * Field Found
     */
    Found(302, "Found"),

    /**
     * Field BadRequests
     */
    BadRequests(400, "Bad Requests"),
    /**
     * Field Unauthorized
     */
    Unauthorized(401, "Unauthorized"),
    /**
     * Field Forbidden
     */
    Forbidden(403, "Forbidden"),
    /**
     * Field NotFound
     */
    NotFound(404, "Not Found"),

    /**
     * Field InternalServerError
     */
    InternalServerError(500, "Internal Server Error")
    ;

    /**
     * Field code 响应状态码
     */
    private final Integer code;


    /**
     * Field 响应状态描述
     */
    private final String desc;

    /**
     * Constructor StatusCodeEnum creates a new StatusCodeEnum instance.
     *
     * @param code of type int
     * @param desc of type String
     */
    StatusCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Method getCode returns the code of this StatusCodeEnum object.
     *
     *  Field code 响应状态码
     *
     * @return the code (type Integer) of this StatusCodeEnum object.
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Method getDesc returns the desc of this StatusCodeEnum object.
     *
     *  Field 响应状态描述
     *
     * @return the desc (type String) of this StatusCodeEnum object.
     */
    public String getDesc() {
        return desc;
    }
}
