package com.melody.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author: melody
 * @Date: 2020-05-28
 */
public class DateUtils {

    /**
     * 获取当天的开始时间
     * @return 当天的开始时间
     */
    public static Date getDayBegin(){
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
        return cal.getTime();
    }

    /**
     * 获取当天的结束时间
     * @return 当天的结束时间
     */
    public static Date getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 获取昨天的开始时间
     * @return 昨天的开始时间
     */
    public static Date getBeginDayOfYesterday(){
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH,-1);
        return cal.getTime();
    }

    /**
     * 获取明天的开始时间
     * @return 明天的开始时间
     */
    public static Date getBeginDayOfTomorrow() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    public static void main(String[] args) {
        System.out.println(getDayBegin());
        System.out.println(getDayEnd());
    }
}
