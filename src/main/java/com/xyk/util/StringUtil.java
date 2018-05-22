package com.xyk.util;


import org.apache.log4j.Logger;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    private final static Logger logger = Logger.getLogger(StringUtil.class);
    //md5加密用的值
    private final static String SALT = "C,./j1`j2`1clxzc?>XC,./4124j0/*-(*%^^231ぁjwq398<>/.zc";

    /**
     * 利用MD5加密
     * @param str 待加密的字符串
     * @return 加密后的字符串
     */
    public static String EncoderByMd5(String str){
        //加密算法
        str = SALT +str;
        String newStr = null;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            //加密后的字符串
            newStr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        } catch (Exception e) {
             logger.error("MD5加密失败! str:"+str);
            e.printStackTrace();
        }
        return newStr;
    }
    /**
     * 判断字符串是否为空
     * @param str
     * @return is null:true else false
     */
    public static boolean isNull(String str){
        return null==str||"".equals(str.trim());
    }
     /**
     * 下划线转驼峰法
     * @param line 源字符串
     * @param smallCamel 大小驼峰,是否为小驼峰 true:首字母小写 false:首字母大写
     * @return 转换后的字符串
     */
    public static String underline2Camel(String line,boolean smallCamel){
        if(StringUtil.isNull(line)) return "";
        if(line.lastIndexOf('_') == -1) return line;

        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher = pattern.matcher(line);
        while(matcher.find()){
            String word = matcher.group();
            sb.append(smallCamel&&matcher.start()==0?Character.toLowerCase(word.charAt(0)):Character.toUpperCase(word.charAt(0)));
            int index = word.lastIndexOf('_');
            if(index>0){
                sb.append(word.substring(1, index).toLowerCase());
            }else{
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }
     /**
     * 创建指定数量的随机字符串
     * @param numberFlag 是否是数字
     * @param length
     * @return
     */
    public static String createRandom(boolean numberFlag, int length){
        String retStr = "";
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);

        return retStr;
    }

}
