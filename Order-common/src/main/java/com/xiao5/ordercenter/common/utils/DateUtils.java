package com.xiao5.ordercenter.common.utils;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间获取及格式转换工具类
 * @author Wu Tianbing
 */
public class DateUtils {
    private static ThreadLocal<DateFormat> jtThreadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHHmmss");
        }
    };

    public static DateUtils jtDateFormat = new DateUtils(jtThreadLocal);

    private ThreadLocal<DateFormat> threadLocal;

    private DateUtils(ThreadLocal<DateFormat> threadLocal){
        this.threadLocal = threadLocal;
    }

    public Date parse(String value) {
        try {
            if(StringUtils.isEmpty(value)){
                return null;
            }
            return this.threadLocal.get().parse(value);
        } catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
    }

    public String format(Date value) {
        if(StringUtils.isEmpty(value)){
            return null;
        }
        return this.threadLocal.get().format(value);
    }
    
    /**
     * 获取YYYYMMDD格式的日期字符串.
     * 
     * @param date
     *            时间
     * @return 时间格式YYYYMMDD
     * @author Wu Tianbing
     * 
     */
    public static String getYYYYMMDD(Date date) {        
        final StringBuffer backstr = new StringBuffer();
        
        if (date == null) {
            date = new Date();
        }
        final SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd");
        final String dateStr = time.format(date);
        backstr.append(dateStr);
        return backstr.toString();
    }

    /**
     * @Author sunrc
     * @Description  获取YYYYMMDDHHMMSS格式的日期字符串.
     * @Date 2019/3/21 17:05
     * @Param [date]
     * @return java.lang.String
     */
    public static String getYYYYMMDDHHMMSS(Date date) {
        final StringBuffer backstr = new StringBuffer();

        if (date == null) {
            date = new Date();
        }
        final SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
        final String dateStr = time.format(date);
        backstr.append(dateStr);
        return backstr.toString();
    }

    /**
     * @Author sunrc
     * @Description 获取传入格式的日期字符串.
     * @Date 2019/4/2 10:57
     * @Param [date, pattern]
     * @return java.lang.String
     */
    public static String getTimeByPattren(Date date,String pattern) {
        final StringBuffer backstr = new StringBuffer();

        if (date == null) {
            date = new Date();
        }
        final SimpleDateFormat time = new SimpleDateFormat(pattern);
        final String dateStr = time.format(date);
        backstr.append(dateStr);
        return backstr.toString();
    }

    /**
     * @Author sunrc
     * @Description 2个日期相差的天数(不考虑时分秒)
     * @Date 2019/4/2 9:47
     * @Param [startDay, endDay]
     * @return void
     */
    public static Long daysOfTwo(String startDay,String endDay) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //跨年不会出现问题
        //如果时间为：2016-03-18 11:59:59 和 2016-03-19 00:00:01的话差值为 0
        Date fDate=sdf.parse(startDay);
        Date oDate=sdf.parse(endDay);
        long days=(oDate.getTime()-fDate.getTime())/(1000*3600*24);

        return days;
    }

    /**
     * @Author sunrc
     * @Description 时间类型转换 String-->Date
     * @Date 2019/4/2 16:34
     * @Param [times]
     * @return java.util.Date
     */
    public static Date StringToDate(String times) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(times);

        return date;
    }

    /**
     * 根据年 月 获取对应的月份 天数
     */
    public static int getDaysByYearMonth(int year, int month) {

        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;

    }

    public static Date getCurrentDate() {
        return new Date();
    }
}