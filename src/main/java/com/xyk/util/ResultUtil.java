package com.xyk.util;

import com.xyk.bean.Result;
import com.xyk.enums.ResultEnum;

public class ResultUtil {
     /**
     * 返回成功 及成功后的数据
     * @param object
     * @return
     */
    public static Result success(Object object){
        return new Result(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),object);
    }
    /**
     * 返回错误信息
     * @param code 错误code
     * @param msg 错误信息
     * @return
     */
    public static Result error(Integer code, String msg){
        return new Result(code,msg);
    }
    /**
     * 返回成功
     * @return
     */
    public static Result success(){
        return success((Object) null);
    }

}
