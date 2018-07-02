package com.woostar.tender.common.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * @author huangs
 * @createtime 2018-05-30
 * @description Date工具类
 */
public final class DateTimeUtil {
    /**
     * 默认日期格式
     */
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 构造器私有化
     */
    private DateTimeUtil() {
    }

    /**
     * String转换为Date
     * @param targetString 目标String对象
     * @param format 转换格式
     * @return 转换后的Date对象
     */
    public static Date stringToDate(String targetString, String format) {
        if (StringUtils.isNotEmpty(targetString)) {
            return DateTimeFormat.forPattern(format).parseDateTime(targetString).toDate();
        }
        return null;
    }

    /**
     * Date转换为String
     * @param targetDate 目标Date对象
     * @param format 转换格式
     * @return 转换后的String对象
     */
    public static String dateToString(Date targetDate, String format) {
        if (targetDate == null) {
            return StringUtils.EMPTY;
        }
        return new DateTime(targetDate).toString(format);
    }
}
