package com.xiaoxianchen.common.result;

//列举响应码
public enum ResCode {

    //成功
    SUCCESS(200),

    //失败
    FAIL(400),

    //未认证
    UNAUTHORIZED(401),

    //接口不存在
    NOT_FOUND(404),

    //服务器内部出现错误
    INTERNAL_SERVER_ERROR(500);

    public int code;

    ResCode(int code) {
        this.code = code;
    }
}
