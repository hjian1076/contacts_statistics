package com.xyk.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 追风少年
 *
 * @email doubihah@foxmail.com
 * @create 2017-06-09 16:16
 **/
public class ObjectUtil {

    private static final DateFormat yyyy_MM_dd_HH_mm_ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * object 转字符串
     * @param object
     * @return
     */
    public static String objectToString(Object object){
        return object==null?null:object.toString();
    }

    /**
     * Object（Date） 转String
     * @param object
     * @return
     */
    public static String objectToDateString(Object object){
        if(object==null) return null;
        Date date = (Date) object;
        return yyyy_MM_dd_HH_mm_ss.format(date);
    }

    /**
     * object 转 byte
     * @param object
     * @return
     */
    public static int objectToByte(Object object){
        int result = 0;
        if(object!=null){
            result = Byte.valueOf(object.toString());
        }
        return result;
    }

    /**
     * object 转 int
     * @param object
     * @return
     */
    public static int objectToInt(Object object){
        int result = 0;
        if(object!=null){
            result = Integer.valueOf(object.toString());
        }
        return result;
    }

    /**
     * object 转 long
     * @param object
     * @return
     */
    public static Long objectToLong(Object object){
        long result = 0L;
        if(object!=null){
            result = Long.valueOf(object.toString());
        }
        return result;
    }

    /**
     * object 转 double
     * @param object
     * @return
     */
    public static double objectToDouble(Object object){
        double result = 0;
        if(object!=null){
            result = Double.valueOf(object.toString());
        }
        return result;
    }

}
