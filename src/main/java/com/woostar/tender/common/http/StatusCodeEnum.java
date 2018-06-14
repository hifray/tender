package com.woostar.tender.common.http;

/**
 * @author huangs
 * @createtime 2018-06-05
 * @description http状态码枚举类
 */
public enum StatusCodeEnum {

    OK(200, "OK"),
    Created(201, "Created"),
    Accepted(202, "Accepted"),

    MovedPermanently(301, "Moved Permanently"),
    Found(302, "Found"),

    BadRequests(400, "Bad Requests"),
    Unauthorized(401, "Unauthorized"),
    Forbidden(403, "Forbidden"),
    NotFound(404, "Not Found"),

    InternalServerError(500, "Internal Server Error")
    ;

    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 描述
     */
    private final String desc;

    StatusCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
