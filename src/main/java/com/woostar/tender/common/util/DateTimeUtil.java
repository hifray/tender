package com.woostar.tender.common.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * Class DateTimeUtil Date工具类
 *
 * @author huangshuo
 * Created on 2018-05-30
 */
public final class DateTimeUtil {

    /**
     * Field DEFAULT_FORMAT 默认日期格式
     */
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Constructor DateTimeUtil creates a new DateTimeUtil instance.
     * 构造器私有化
     */
    private DateTimeUtil() {
    }

    /**
     * Method String转Date
     *
     * @param targetString of type String 目标String
     * @param format of type String 转换格式
     * @return Date
     */
    public static Date stringToDate(String targetString, String format) {
        if (StringUtils.isNotEmpty(targetString)) {
            return DateTimeFormat.forPattern(format).parseDateTime(targetString).toDate();
        }
        return null;
    }

    /**
     * Method dateToString Date转String
     *
     * @param targetDate of type Date 目标Date
     * @param format of type String 转换格式
     * @return String
     */
    public static String dateToString(Date targetDate, String format) {
        if (targetDate == null) {
            return StringUtils.EMPTY;
        }
        return new DateTime(targetDate).toString(format);
    }
}
