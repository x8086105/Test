package com.example.demo;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 公共操作类
 *
 * @ClassName: CommonOper
 * @auther RyanChou
 * @date 2014-10-16
 * @time 下午3:24:52
 */
//implements Comparator
public class DateUtils {


    /**
     * 获取当前时间
     *
     * @return
     * @methodName: getCurrentDate
     * @returnType: String
     */
    public static String getCurrentDate() {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(calendar.getTime());
        return dateStr;
    }

    /**
     * 获取当前时间
     *
     * @return
     * @methodName: getCurrentTime
     * @returnType: String
     */
    public static String getCurrentTime() {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(calendar.getTime());
        return dateStr;
    }

    public static String getDateTimeFormat(Date d) {
        DateFormat formartDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sDate = formartDate.format(d);
        return sDate;
    }

    /**
     * 格式化日期格式 （年-月-日）
     *
     * @param d
     * @return
     * @methodName: getDateFormat
     * @returnType: String
     */
    public static String getDateFormat(Date d) {
        DateFormat formartDate = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = formartDate.format(d);
        return sDate;
    }

    /**
     * 根据日期获取时间
     *
     * @param d 日期
     * @return 时间
     * @methodName: getTimeFormat
     * @returnType: String
     */
    public static String getTimeFormat(Date d) {
        DateFormat formartTime = new SimpleDateFormat("HH:mm:ss");
        String sTime = formartTime.format(d);
        return sTime;
    }

    /**
     * 字符串格式化成日期
     *
     * @param dateStr
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static LocalDate formatStr(String dateStr, String pattern) throws ParseException {
//		DateFormat formartTime = new SimpleDateFormat(pattern);
//		Date sTime = null;
//		sTime = formartTime.parse(dateStr);
//		return sTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate date = LocalDate.parse(dateStr, formatter);
        return date;
    }

    /**
     * 获取最后的激活时间 （注册时调用到）
     * 最后的激活时间往后延两天
     *
     * @return
     */
    public static Date getLastActivateTime() {
        Date date = new Date();// 取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 2);// 把日期往后增加一天.整数往后推,负数往前移动
        date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
        return date;
    }


    /**
     * 时间戳转化为Sting或Date
     *
     * @return
     */
    public static Date timestampToDate(String timestamp) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long time = new Long(timestamp);
        String d = format.format(time);
        Date date = null;
        try {
            date = format.parse(d);
        } catch (ParseException e) {
        }
        return date;
    }
    /**
     * 时间戳转化为Sting
     *
     * @return
     */
    public static String timestampToStr(Long timestamp) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp),ZoneId.systemDefault());
        return localDateTime.format(dtf);
    }

    //    获取时间戳1970-02-01 00:00:00
    public static Date get1970_2_1Date() {
        Date date = timestampToDate("2649600000");
        return date;
    }

    /**
     * 获取当天的起始时间
     */
    public static Date getTodayStartTime() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date startTime = calendar.getTime();
        return startTime;
    }


    /**
     * 获取当前的日期（yyyy-MM-dd）
     *
     * @return
     */
    public static Date getcurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(new Date());

        Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取当前年月（yyyy-MM）
     *
     * @return
     */
    public static String getcurrentMouth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String s = sdf.format(new Date());
        return s;
    }

    /**
     * 获取当前年月 的date
     *
     * @return
     */
    public static Date getcurrentMouthDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String s = sdf.format(new Date());


        Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;

    }

    /**
     * 获取昨天的日期
     *
     * @return
     */
    public static Calendar getyesterdayCalendar() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal;
    }

    /**
     * 获取今天的日期
     *
     * @return
     */
    public static Calendar gettodayCalendar() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        return cal;
    }

    /**
     * 获取昨天的日期（yyyy-MM-dd）
     *
     * @return
     */
    public static Date getyesterdayDate() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
        try {
            date = sdf.parse(yesterday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 获取明天的日期（yyyy-MM-dd）
     *
     * @return
     */
    public static Date getTomorrowDate() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
        try {
            date = sdf.parse(yesterday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 获取某个日期的明天的日期（yyyy-MM-dd）
     *
     * @return
     */
    public static String getTomorrowDate(String dateStr) {


        Date date1 = stringToDateYYYYmmdd(dateStr);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        cal.add(Calendar.DATE, 1);
        String tomorrow = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

        return tomorrow;
    }

    /**
     * 判断是不是周末（yyyy-MM-dd）
     *
     * @return
     */
    public static Boolean isWeekend(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        }
        return false;
    }

    //获取当前月第一天：
    public static String getFirstDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String first = format.format(c.getTime());
        return first;

    }

    //获取当前月的list
    public static List<String> getcurrentMouthList(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);

        List<String> dateList = new ArrayList<>();
        int days = getDays(date);

        for (int i = 1; i <= days; i++) {
            c.set(Calendar.DAY_OF_MONTH, i);//设置为1号,当前日期既为本月第一天
            String dateStr = format.format(c.getTime());

            dateList.add(dateStr);

        }
        return dateList;

    }


    public static Date stringToDateHHmm(String str) {
        return stringToDate(str, "HH:mm");
    }

    public static Date stringToDateYYYYmm(String str) {
        return stringToDate(str, "yyyy-MM");

    }

    public static Date stringToDateYYYYmmdd(String str) {
        return stringToDate(str, "yyyy-MM-dd");
    }

    public static Date stringToDate(String str) {
        return stringToDate(str, "yyyy-MM-dd HH:mm:ss");
    }

    private static Date stringToDate(String str, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = formatter.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }

    //            获取某一天是这个月的第几天

    public static int getDays(Date date) {


        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String st = sdf.format(date);
//        int i = ca.get(Calendar.DAY_OF_YEAR);
        int a = ca.get(Calendar.DAY_OF_MONTH);
        return a;
//        System.out.println("当前时间是：" + st + ";一年中的" + i + "一个月中的" + a);
    }


    public static Date getFirstDayOfCurrentMouth() {
        //获取当前月第一天：

        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String first = format.format(c.getTime());


        return stringToDate(first, "yyyy-MM-dd");
    }


    public static Date getLastDayOfCurrentMouth() {
        //获取当前月最后一天

        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String first = format.format(ca.getTime());


        return stringToDate(first, "yyyy-MM-dd");
    }


    public static String getFirstDayOfCurrentMouthString() {
        //获取当前月第一天：

        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String first = format.format(c.getTime());


        return first;
    }


    public static String getLastDayOfCurrentMouthString() {
        //获取当前月最后一天

        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String first = format.format(ca.getTime());


        return first;
    }

    /**
     * 根据时间排序，递减
     *
     * @return
     */
//	@Override
//	public int compare(Object o1, Object o2) {
//		DiscoveryVo begin = (DiscoveryVo) o1;
//		DiscoveryVo end = (DiscoveryVo) o2;
//		if (begin.getPublishTime().before(end.getPublishTime())) {
//			return 1;
//		} else {
//			return -1;
//		}
//
//	}

    /**
     * 获取几天前的日期（ 计算相减day天，并且排除周末的日期,只含工作日）
     *
     * @return
     */
    public static String reduceDatebyWorkday(Calendar calendar, int day) {
        try {
            for (int i = 0; i < day; i++) {

                calendar.add(Calendar.DAY_OF_MONTH, -1);

                if (checkHoliday(calendar)) {
//                    其实就是相当于把day加1了
                    i--;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(calendar.getTime());
    }


    /**
     * <p>Title: addDateByWorkDay </P>
     * <p>Description:  计算相加day天，并且排除周末后的日期</P>
     *
     * @param calendar 当前的日期
     * @param day      相加天数
     * @return return Calendar    返回类型   返回相加day天，并且排除周末后的日期
     * throws
     */
    public static String addDateByWorkDay(Calendar calendar, int day) {

        try {
            for (int i = 0; i < day; i++) {

                calendar.add(Calendar.DAY_OF_MONTH, 1);

                if (checkHoliday(calendar)) {
//                    其实就是相当于把day加1了
                    i--;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(calendar.getTime());
    }

    /**
     * <p>Title: checkHoliday </P>
     * <p>Description: 验证日期是否是节假日(现在只包括周末)</P>
     *
     * @param calendar 传入需要验证的日期
     * @return return boolean    返回类型  返回true是节假日，返回false不是节假日
     * throws
     */
    public static boolean checkHoliday(Calendar calendar) throws Exception {

        //判断日期是否是周六周日
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            return true;
        }

        return false;
    }

    /**
     * 获取几天前,或者几天后你的日期
     *
     * @param day
     * @return
     */
    public static String getDayBefore(long day) {

        //获取7天前的日期

        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.minusDays(day);
        ZonedDateTime zdt = localDateTime.atZone(zoneId);

        Date date = Date.from(zdt.toInstant());

        String dateFormat = DateUtils.getDateFormat(date);

        return dateFormat;
    }

    public static Date getDayBeforeDate(long day) {

        //获取7天前的日期

        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.minusDays(day);
        ZonedDateTime zdt = localDateTime.atZone(zoneId);

        Date date = Date.from(zdt.toInstant());


        return date;
    }
    public static String getDayBeforeMonth(long month) {

        //获取3个月前的日期

        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.minusMonths(month);
        ZonedDateTime zdt = localDateTime.atZone(zoneId);

        Date date = Date.from(zdt.toInstant());
        String dateFormat = DateUtils.getDateTimeFormat(date);

        return dateFormat;
    }


    /**
     * 字符串格式化成日期
     *
     * @param dateStr
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date formatStr2Date(String dateStr, String pattern) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate date = LocalDate.parse(dateStr, formatter);
        ZoneId zoneId = ZoneId.systemDefault();
        date.atStartOfDay(zoneId);
        ZonedDateTime zdt = date.atStartOfDay(zoneId);

        return Date.from(zdt.toInstant());
    }

    public static Date addDay(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, day);
        return c.getTime();
    }

    public static Date getStartDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(date);

        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取某个时间到前x天的日期集合
     *
     * @param date
     * @param day
     * @return
     */
    public static List<Date> getDateList(Date date, int day) {
        List<Date> dates = new ArrayList<>(day + 1);
        for (int i = 0; i < day; i++) {
            dates.add(getStartDate(addDay(date, -i)));
        }
        return dates;
    }

    /**
     * 得到几天前的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * 得到几天后的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    /**
     * 返回两个日期的相差天数
     *
     * @param bigDate   : 大的天数
     * @param smallDate : 小的天数
     * @return
     */
    public static long getTimeDifference(Date smallDate, Date bigDate) {
        //一天的毫秒数
        long d = 1000 * 24 * 60 * 60;
        //一小时的毫秒数
        long h = 1000 * 60 * 60;
        //一分钟的毫秒数
        long m = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long timeDiff = bigDate.getTime() - smallDate.getTime();
        // 计算差多少天
        long day = timeDiff / d;
        // 计算差多少小时
        long hour = timeDiff % d / h;
        // 计算差多少分钟
        long min = timeDiff % d % h / m;
        //输出结果
        return day;
    }


    /**
     * 返回两个日期的相差分钟数
     *
     * @param bigDate   : 大的天数
     * @param smallDate : 小的天数
     * @return
     */
    public static String getTimeDifferenceStr(Date smallDate, Date bigDate) {
        //一天的毫秒数
        long d = 1000 * 24 * 60 * 60;
        //一小时的毫秒数
        long h = 1000 * 60 * 60;
        //一分钟的毫秒数
        long m = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long timeDiff = bigDate.getTime() - smallDate.getTime();
        // 计算差多少天
        long day = timeDiff / d;
        // 计算差多少小时
        long hour = timeDiff % d / h;
        // 计算差多少分钟
        long min = timeDiff % d % h / m;
        //输出结果
        return day + "天" + hour + "小时" + min + "分";
    }

    /**
     * 获取此刻与相对当天第day天的起始时间相隔的秒数。day为0表示今天的起始时间；1明天，2后天，-1昨天，-2前天等，依次例推。
     *
     * @param day
     * @return
     */
    public static int ttl(int day) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime time = LocalDate.now().plusDays(day).atStartOfDay();
        int ttl = (int) Duration.between(now, time).toMillis() / 1000;
        return ttl;
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    public static String date2String(Date date, String formatter) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter);

        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        String dateStr = dateTimeFormatter.format(localDateTime);

        return dateStr;
    }
    //只根据年份和天数来比.
    public static long getOnlyDateDiff(Date comparedDate, Date compareDate ) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(comparedDate);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(compareDate);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                // 区分闰年与非闰年的区别
                // 普通闰年:能被4整除但不能被100整除的年份为普通闰年。（如2004年就是闰年，1900年不是闰年）；
                // 世纪闰年:能被400整除的为世纪闰年。
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    timeDistance += 366;
                } else {
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else {
            //同一年的情况下
            return day2 - day1;
        }
    }

    public static String getCurrentDateAndSecond(int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, second);
        FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.SSS");
        return fdf.format(calendar.getTime());
    }

    public static Date getDateAndRandomSecond(Date date, int second) {
        if (date == null) {
            return date;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, new Random().nextInt(second));
        return calendar.getTime();
    }

    /**
     * 解析日期<br>
     * @author Napoleon
     * @param dateStr
     * @return
     */
    public static Date parseDate(String dateStr) {
        SimpleDateFormat format = null;
        if (StringUtils.isBlank(dateStr))
            return null;
        String _dateStr = dateStr.trim();
        try {
            if (_dateStr.matches("\\d{1,2}[A-Z]{3}")) {
                _dateStr = _dateStr
                        + (Calendar.getInstance().get(Calendar.YEAR) - 2000);
            }
            // 01OCT12
            if (_dateStr.matches("\\d{1,2}[A-Z]{3}\\d{2}")) {
                format = new SimpleDateFormat("ddMMMyy", Locale.ENGLISH);
            } else if (_dateStr.matches("\\d{1,2}[A-Z]{3}\\d{4}.*")) {// 01OCT2012
                // ,01OCT2012
                // 1224,01OCT2012
                // 12:24
                _dateStr = _dateStr.replaceAll("[^0-9A-Z]", "")
                        .concat("000000").substring(0, 15);
                format = new SimpleDateFormat("ddMMMyyyyHHmmss", Locale.ENGLISH);
            } else {
                StringBuffer sb = new StringBuffer(_dateStr);
                String[] tempArr = _dateStr.split("\\s+");
                tempArr = tempArr[0].split("-|\\/");
                if (tempArr.length == 3) {
                    if (tempArr[1].length() == 1) {
                        sb.insert(5, "0");
                    }
                    if (tempArr[2].length() == 1) {
                        sb.insert(8, "0");
                    }
                }
                _dateStr = sb.append("000000").toString().replaceAll("[^0-9]",
                        "").substring(0, 14);
                if (_dateStr.matches("\\d{14}")) {
                    format = new SimpleDateFormat("yyyyMMddHHmmss");
                }
            }
            Date date = format.parse(_dateStr);
            return date;
        } catch (Exception e) {
            throw new RuntimeException("无法解析日期字符[" + dateStr + "]");
        }
    }

    /**
     * 格式化日期, 可变参传递日期格式
     * @author Napoleon
     * @param date
     * @param patterns
     * @return
     */
    public static String format(Date date, String... patterns) {
        if (date == null) {
            return "";
        }
        String pattern = "yyyy-MM-dd HH:mm:ss";
        if (patterns != null && patterns.length > 0
                && org.apache.commons.lang3.StringUtils.isNotBlank(patterns[0])) {
            pattern = patterns[0];
        }
        return DateFormatUtils.format(date, pattern);
    }

}
