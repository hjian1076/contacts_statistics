package com.xyk.util;

import com.google.gson.Gson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * JSON工具类
 *
 * @author hejx
 * @email doubihah@foxmail.com
 * @create 2017-05-23 14:46
 **/
public class JsonUtil {

//    ObjectMapper mapper = new ObjectMapper();

    public final static Gson GSON = new Gson();

    /**
     * 将对象转为JSON字符串
     * @param obj 不能传数组(List...) 会报500异常
     * @return JSON字符串
     */
    public static String toJson(Object obj){
        JSONObject jsonObject = JSONObject.fromObject(obj);
        return jsonObject.toString();
    }

    /**
     * 利用Gson将对象转为JSON字符串
     * @param obj
     * @return
     */
    public static String toJsonByGson(Object obj){
        return GSON.toJson(obj);
    }

    /**
     * 将JSON字符串转为Map集合
     * @param jsonStr
     * @return
     */
    public static Map<String,Object> jsonToMap(String jsonStr){
        return GSON.fromJson(jsonStr,Map.class);
    }

    /**
     * 将list对象转为JSON字符串
     * @param arr
     * @return JSON字符串
     */
    public static String arrayToJson(List arr){
        JSONArray arrayjson = JSONArray.fromObject(arr);
        return arrayjson.toString();
    }



}
