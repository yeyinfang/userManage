package com.ye.common;

/**
 * @program: maven-ssm
 * @description: 用来接受返回的返回值的
 * @author: YF
 * @create: 2018-07-03 16:00
 **/
public class ResponseResult<T> {
    //状态
    private int status;
    //想要返回的string类想的
    private String message;
    //返回数据
    private T data;


    //构造函数
    public ResponseResult(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    //接下来就是如果只有其中一个有值
    //返回的是信息
    public static ResponseResult success(String message){
        return new ResponseResult(0,message,null);
    }
    public static<T> ResponseResult success(T data){
        return new ResponseResult(0,null,data);
    }
    public static ResponseResult error(String message){
        return new ResponseResult(-1,message,null);
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
