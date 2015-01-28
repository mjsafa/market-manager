package com.arman.csb.util;

import com.liferay.portal.kernel.util.StringUtil;
import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Mojtaba SAFAEIAN
 * Date: 1/15/15
 * Time: 5:15 PM
 */
public class DateUtil extends com.liferay.portal.kernel.util.DateUtil {

    public static final String TIME_PERIOD_DAY = "day";
    public static final String TIME_PERIOD_WEEK = "week";
    public static final String TIME_PERIOD_MONTH = "month";
    public static final String TIME_PERIOD_YEAR = "year";

    public static final String TIME_PERIOD_DEFAULT = TIME_PERIOD_MONTH;

    public static final Date parseDate(String dateString) {
        DateFormat dateFormat = new SimpleDateFormat(MapUtil.DATE_PATTERN);
        try {
            return dateFormat.parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }

    public static final Date getToDate(String dateFromString, String timePeriodString, String defaultTimePeriod) {
        Date dateFrom = parseDate(dateFromString);
        String timePeriod = StringUtils.isEmpty(timePeriodString) ? defaultTimePeriod : timePeriodString;
        timePeriod = StringUtils.isEmpty(timePeriod) ? TIME_PERIOD_DEFAULT : timePeriod;

        Calendar calendar = Calendar.getInstance();
        if (null != dateFrom) {
            calendar.setTime(dateFrom);
            if (timePeriod.equals(TIME_PERIOD_DAY)) {
                calendar.add(Calendar.DATE, 1);
            } else if (timePeriod.equals(TIME_PERIOD_WEEK)) {
                calendar.add(Calendar.WEEK_OF_YEAR, 1);
            } else if (timePeriod.equals(TIME_PERIOD_MONTH)) {
                calendar.add(Calendar.MONTH, 1);
            } else if (timePeriod.equals(TIME_PERIOD_YEAR)) {
                calendar.add(Calendar.YEAR, 1);
            }

            //if toDate is in future -> return now else return toDate
            if (calendar.getTime().compareTo(new Date()) > 0) {
                return new Date();
            } else {
                return calendar.getTime();
            }
        } else {
            return new Date();
        }
    }

    public static final Date getToDate(String dateFromString, String timePeriodString) {
        return getToDate(dateFromString, timePeriodString, TIME_PERIOD_DEFAULT);
    }


    public static final Date getFromDate(String dateFromString, String timePeriodString, String defaultTimePeriod) {
        Date dateFrom = parseDate(dateFromString);
        String timePeriod = StringUtils.isEmpty(timePeriodString) ? defaultTimePeriod : timePeriodString;
        timePeriod = StringUtils.isEmpty(timePeriod) ? TIME_PERIOD_DEFAULT : timePeriod;

        Calendar calendar = Calendar.getInstance();
        if (null != dateFrom) {
            return dateFrom;
        } else {
            if (timePeriod.equals(TIME_PERIOD_DAY)) {
                calendar.add(Calendar.DATE, -1);
            } else if (timePeriod.equals(TIME_PERIOD_WEEK)) {
                calendar.add(Calendar.WEEK_OF_YEAR, -1);
            } else if (timePeriod.equals(TIME_PERIOD_MONTH)) {
                calendar.add(Calendar.MONTH, -1);
            } else if (timePeriod.equals(TIME_PERIOD_YEAR)) {
                calendar.add(Calendar.YEAR, -1);
            }
            return calendar.getTime();
        }
    }

    public static final Date getFromDate(String dateFromString, String timePeriodString) {
        return getFromDate(dateFromString, timePeriodString, TIME_PERIOD_DEFAULT);
    }

    public static final String getString(Date date) {
        try {
            DateFormat df = new SimpleDateFormat(MapUtil.DATE_PATTERN);
            return df.format(date);
        } catch (Exception e) {
            return null;
        }
    }


    public static final Long getTime(Date date) {
        if(null != date){
            return date.getTime();
        }else {
            return null;
        }
    }
}
