package com.xyk.util.memory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 追风少年
 * 内存数据
 * @email doubihah@foxmail.com
 * @create 2017-06-08 15:59
 **/
public class MemoryData {

    //用于储存用户登录的sessionID
    private static Map<String, String> sessionIDMap = new HashMap<String,String>();

    public static Map<String, String> getSessionIDMap() {
        return sessionIDMap;
    }

    public static void setSessionIDMap(Map<String, String> sessionIDMap) {
        MemoryData.sessionIDMap = sessionIDMap;
    }

}
