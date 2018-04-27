package com.xyk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期工具类
 *
 * @author hejx
 * @email doubihah@foxmail.com
 * @create 2017-05-27 11:43
 **/
public class DateUtil {

    private final static Long DAY_MILLISECONDS = 86400000l;  //一天的毫秒数

    private final static Long HOUR_MILLISECONDS = 3600000l;    //一小时的毫秒数

    /**
     * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss'(24小时制)<br>
     * 如Sat May 11 17:24:21 CST 2002 to '2002-05-11 17:24:21'<br>
     * @param time Date 日期<br>
     * @return String   字符串<br>
     */
    public static String dateToString(Date time){
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        String ctime = formatter.format(time);
        return ctime;
    }

    /**
     * 字符串转日期类型
     * @param str
     * @param pattern
     * @return Date
     */
    public static Date stringToDate(String str,String pattern) {
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            return format.parse(str);
        } catch (Exception e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return null;
        }
    }

    /**
     * 验证日期格式
     * @param str
     * @param pattern yyyy/MM/dd HH:mm:ss
     * @return 合格:true else false
     */
    public static boolean isValidDate(String str,String pattern) {
        boolean convertSuccess=true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (Exception e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess=false;
        }
        return convertSuccess;
    }

    /**
     * 获得传入时间内的天数
     * @param endTime     时间格式:yyyy-MM-dd
     * @param beginTime   时间格式:yyyy-MM-dd
     * @return
     * @throws ParseException   时间转换异常
     */
    public static Map<String,String> getDays(String endTime,String beginTime) throws ParseException {
        Map<String,String> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long time1 = sdf.parse(endTime).getTime();
        long time2 = sdf.parse(beginTime).getTime();
        long time = time1 - time2;
        if(time < 0){
            String tempTime = beginTime;
            beginTime = endTime;
            endTime = tempTime;
            time = time2 - time1;
        }
        map.put("beginTime",beginTime);
        map.put("endTime",endTime);
        map.put("total",(time/DAY_MILLISECONDS + 1) + "");
        return map;
    }

    /**
     * 在当前时间基础上加一天
     * @param date      时间格式:yyyy-MM-dd
     * @return
     * @throws ParseException   时间转换异常
     */
    public static String addOneDay(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date(sdf.parse(date).getTime() + DAY_MILLISECONDS);
        return sdf.format(d);
    }

    /**
     * 获得传入时间内的小时数
     * @param endTime     时间格式:yyyy-MM-dd HH
     * @param beginTime   时间格式:yyyy-MM-dd HH
     * @return
     * @throws ParseException   时间转换异常
     */
    public static Map<String,String> getHours(String endTime,String beginTime) throws ParseException {
        Map<String,String> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        long time1 = sdf.parse(endTime).getTime();
        long time2 = sdf.parse(beginTime).getTime();
        long time = time1 - time2;
        if(time < 0){
            String tempTime = beginTime;
            beginTime = endTime;
            endTime = tempTime;
            time = time2 - time1;
        }
        map.put("beginTime",beginTime);
        map.put("endTime",endTime);
        map.put("total",(time/HOUR_MILLISECONDS + 1) + "");
        return map;
    }

    /**
     * 在当前时间基础上加一小时
     * @param date      时间格式:yyyy-MM-dd HH
     * @return
     * @throws ParseException   时间转换异常
     */
    public static String addOneHour(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        Date d = new Date(sdf.parse(date).getTime() + HOUR_MILLISECONDS);
        return sdf.format(d);
    }

}
