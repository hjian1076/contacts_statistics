package com.xyk.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 集合工具类
 * Created by mattyang on 2017/5/2.
 */
public class ColUtil {
    /**
     * 判断col集合是不是为空(null或者size==0)
     */
    public static <T> boolean isEmpty(Collection<T> col) {
        return col == null || col.isEmpty();
    }

    /**
     * 判断map映射是不是为空(null或者size==0)
     */
    public static boolean isEmpty(Map<?,?> map) {
        return map == null || map.isEmpty();
    }


    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 将map中的values转换成一个Arraylist
     */
    public static <V> ArrayList<V> fromMapValuesToArrayList(Map<?, V> map) {
        if(ColUtil.isEmpty(map)) {
            return null;
        }
        ArrayList<V> result = new ArrayList<V>();
        for(V value : map.values()) {
            result.add(value);
        }
        return result;
    }
    /**
     * 克隆一个map，实质克隆出的map为hashMap
     * @param <K>
     * @param <V>
     * @param sourceMap 源map
     * @return
     */
    public static <K, V> Map<K, V> cloneMap(Map<K, V> sourceMap) {
        if(isEmpty(sourceMap)) {
            return null;
        }
        Map<K, V> result = new HashMap<K, V>();
        for(K k : sourceMap.keySet()) {
            result.put(k, sourceMap.get(k));
        }
        return result;
    }
}
