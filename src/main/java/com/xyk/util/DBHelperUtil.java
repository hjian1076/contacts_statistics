package com.xyk.util;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 追风少年
 * 查询出来的dt 转 beans 的工具类
 * @email doubihah@foxmail.com
 * @create 2017-08-29 15:12
 **/
public class DBHelperUtil {

    private static final Logger logger = Logger.getLogger(DBHelperUtil.class);

    /**
    public static void main(String[] args) throws Exception {
        List datalist = new ArrayList();
        //id,name,role_uid,acc_id,sid,sex,login_ip,login_time,money,gold,roomcard,sum_online
        Map<String,Object> row = new HashedMap();
        row.put("id",66);
        row.put("name","王三");
        row.put("role_uid",1000025);
        row.put("gold",0);
        datalist.add(row);
        row = new HashedMap();
        row.put("id",63);
        row.put("name","王222三");
        row.put("role_uid",100020);
        row.put("gold",0);
        datalist.add(row);
        List list = fillDataInfo(datalist, LoginInfoModel.class);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());

        }
        String s = "role_uid";
        String s2 = "roleUid_iw";
        String s1 = StringUtil.underline2Camel(s, true);
        String s3 = StringUtil.underline2Camel(s2, true);
        System.out.println(s1);
        System.out.println(s3);

    }
     **/

    /**
     * 组装实体
     * 利用查询出来的 列名 寻找驼峰式的实体字段 进行填充
     * @param datalist
     * @param clss 实体class
     * @return
     * @throws Exception
     */
    public static List fillDataInfo(List datalist, Class clss) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        List list = new ArrayList();
        Map row = null;
        Field[] declaredFields = null;
        //防止报空指针异常
        if(ColUtil.isEmpty(datalist)){
            return list;
        }
        for (Object obj : datalist) {
            Object temp = clss.newInstance();
            row = (Map) obj;

            for (Object key : row.keySet()) {
                Field field = null;
                String fieldName = key.toString();
                declaredFields = clss.getDeclaredFields();

                for (int i = 0; i < declaredFields.length; i++) {
                    // 查询对应的字段
                    String tempName = StringUtil.underline2Camel(fieldName, true); // 将下划线转为驼峰
                    if(tempName.equalsIgnoreCase(declaredFields[i].getName())){
                        field = declaredFields[i];
                        break;
                    }
                }//for
                if(field==null){
                    throw new Exception("数据库查询出来的字段: "+fieldName+" ! 在实体类中无对应,请检查实体后操作! class:" + clss.getSimpleName());
                }
                field.setAccessible(true);//只要Field.setAccessible(true); 之后，即使是final关键字标示过得属性也可以有访问权限
                String fieldTypeName = field.getType().toString();
                Object val = row.get(fieldName);
                if(fieldTypeName.indexOf("Boolean") != -1  || fieldTypeName.equals("boolean") ){
                    if("0".equals(val)){
                        field.set(temp,false);
                    }else if("1".equals(val)){
                        field.set(temp,true);
                    }
                }else if(fieldTypeName.indexOf("BigDecimal")  != -1 ){
                    field.set(temp, val);
                }else if(fieldTypeName.indexOf("Long")  != -1 ){
                    field.set(temp,ObjectUtil.objectToLong(val));
                }else if(fieldTypeName.indexOf("Double")  != -1 || fieldTypeName.equals("double") ){
                    field.set(temp, ObjectUtil.objectToDouble(val));
                }else if(fieldTypeName.indexOf("Integer")  != -1 || fieldTypeName.equals("int") ){
                    field.set(temp, ObjectUtil.objectToInt(val));
                }else if(fieldTypeName.indexOf("Byte")  != -1 || fieldTypeName.equals("byte") ){
                    field.set(temp, ObjectUtil.objectToByte(val));
                }else if(fieldTypeName.indexOf("Date")  != -1 ){
                    try {
                        if(val != null && !"".equals(val.toString())){
                           // if(DateUtil.isValidDate())
                            field.set(temp, format.parse(val.toString()));
                        }else {
                            field.set(temp, null);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                        logger.error(e.getMessage()+" 时间转换错误 ");
                    }
                }else if(val instanceof BigInteger){
                    BigInteger bv = (BigInteger)val;
                    field.set(temp , bv==null?0:bv.longValue());
                }else{
                    field.set(temp, val==null?null:val.toString());
                }
            }
            list.add(temp);
        }

        return list;

    }

}
