package com.xyk.exception;

/**
 * Created by 追风少年
 * 用户重复异常
 * @email doubihah@foxmail.com
 * @create 2017-06-13 16:13
 **/
public class UserRepeatException extends RuntimeException{

    public UserRepeatException(String message) {
        super(message);
    }

    public UserRepeatException(String message, Throwable cause) {
        super(message, cause);
    }

}
