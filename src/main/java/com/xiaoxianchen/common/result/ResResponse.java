package com.xiaoxianchen.common.result;

import java.io.Serializable;

public class ResResponse<T> implements Serializable {
    private final static String SUCCESS = "SUCCESS";

    public static <T> Result<T> makeOKRsp() {
        return new Result<T>().setCode(ResCode.SUCCESS)
                .setMsg(SUCCESS);
    }

    public static <T> Result<T> makeOKRsp(T data) {
        return new Result<T>()
                .setCode(ResCode.SUCCESS)
                .setMsg(SUCCESS)
                .setData(data);
    }

    public static <T> Result<T> makeErrRsp(String msg) {
        return new Result<T>()
                .setCode(ResCode.FAIL)
                .setMsg(msg);
    }

    public static <T> Result<T> makeRsp(Integer code, String msg) {
        return new Result<T>()
                .setCode(code)
                .setMsg(msg);
    }

    public static <T> Result<T> makeRsp(Integer code, String msg, T data) {
        return new Result<T>()
                .setCode(code)
                .setMsg(msg)
                .setData(data);
    }

}
