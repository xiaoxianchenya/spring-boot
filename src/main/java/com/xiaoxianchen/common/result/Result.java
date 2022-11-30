package com.xiaoxianchen.common.result;

import lombok.Getter;

@Getter
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;


    //利用链式编程
    public Result<T> setCode(Integer resCode){
        this.code=resCode;
        return this;
    }
    public Result<T> setCode(ResCode resCode){
        this.code=resCode.code;
        return this;
    }
    public Result<T> setMsg(String msg){
        this.msg=msg;
        return this;
    }

    public Result<T> setData(T data){
        this.data=data;
        return this;
    }

}
